import XCTest
@testable import CrossFoundation
import Foundation

final class CrossFoundationTests: XCTestCase {

    /// Tests to ensure that `XCTest.XCTAssert*` statements are correctly translated into their `JUnit.assert*` equivalents.
    func testTesting() throws {
        //XCTAssertTrue(true) // error on Linux: Type mismatch: inferred type is () -> Boolean but Boolean was expected
        //XCTAssertFalse(false)
        XCTAssertNil(nil)
        XCTAssertNotNil("ABC")
        XCTAssertEqual(1, 1)
        XCTAssertNotEqual("X", "Y")

        class SimpleClass {
            init() { }
        }
        let a = SimpleClass()

        //XCTAssertIdentical(a, a, "a should be a") // erorr on Linux: Type mismatch: inferred type is () -> String but String was expected
        XCTAssertIdentical(a, a)

        let b = SimpleClass()
        XCTAssertNotIdentical(a, b)

        // not supported by JUnit
        // XCTAssertGreaterThan(1, 0)
        // XCTAssertLessThan(0, 1)
        // XCTAssertLessThanOrEqual(1, 1)
        // XCTAssertGreaterThanOrEqual(1, 1)
    }

    func testRandom() {
        XCTAssertNotEqual(Random.shared.randomDouble(), Random.shared.randomDouble(), "random should not repeat")
    }

    func testMath() {
        //XCTAssertEqual(0.1 + 1.0, 1.1)
        XCTAssertEqual(1 + 2, 3)
    }

    func testStringPadding() {
        XCTAssertEqual("abc++", "abc".pad(to: 5, with: "+"))
    }

    func testURLs() {
        let url: URL? = URL.init(string: "https://www.example.org/path/to/file.ext")
        XCTAssertEqual("https://www.example.org/path/to/file.ext", url?.absoluteString)
        XCTAssertEqual("/path/to/file.ext", url?.path)
        XCTAssertEqual("www.example.org", url?.host)
        XCTAssertEqual("ext", url?.pathExtension)

        //XCTAssertEqual("file.ext", url?.lastPathComponent)
        //XCTAssertEqual(false, url?.isFileURL)

        //XCTAssertEqual(nil, url?.relativePath) // should give a deprecation warning: no kotlin equivalent

        //XCTAssertEqual(nil, url?.query)
        //XCTAssertEqual(nil, url?.port)
    }

    func testData() throws {
        //XCTAssertEqual(0, try Data(contentsOfFile: "/dev/null").count) // parameter name is lost externally
        XCTAssertNotEqual(0, try Data.init(contentsOfFile: "/etc/hosts").count)
        XCTAssertNotEqual(0, try Data.init(contentsOf: URL.init(fileURLWithPath: "/etc/hosts", isDirectory: false)).count)
    }

    func testUUID() throws {
        XCTAssertNotEqual(UUID(), UUID())
        XCTAssertNotEqual("", UUID().uuidString)
        print("UUID: \(UUID().uuidString)")
    }

    func testDate() throws {
        let date = Date()
        XCTAssertNotEqual(0, date.timeIntervalSince1970)

        // let d: Date = Date.create(72348932.0) // SourceKit failed to get an expression's type
        //XCTAssertEqual(72348932.0, d.timeIntervalSince1970)
    }
}

#if !GRYPHON
#if canImport(Skiff)
import Skiff

extension CrossFoundationTests {
    /// Transpiles to Kotlin as a side-effect of the test run; this will eventually be a package plug-in, but for now we run it as a side-effect of `swift test`.
    func testKotlinCrossFoundation() throws {
        try Skiff().transpileAndTest()
    }
}
#endif
#endif
