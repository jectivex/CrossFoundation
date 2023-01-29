import XCTest
@testable import CrossFoundation

final class CrossFoundationTests: XCTestCase {

    /// Tests to ensure that `XCTest.XCTAssert*` statements are correctly translated into their `JUnit.assert*` equivalents.
    func testTesting() throws {
        XCTAssertTrue(true)
        XCTAssertFalse(false)
        XCTAssertNil(nil)
        XCTAssertNotNil("ABC")
        XCTAssertEqual(1, 1)
        XCTAssertNotEqual("X", "Y")

        class SimpleClass {
            let value: Int
            init(value: Int) { self.value = value }
        }

        let a = SimpleClass(value: 1)

        XCTAssertIdentical(a, a) // on linux types inferred as () -> Any

        let b = SimpleClass(value: 1)
//        XCTAssertEqual(a, b)
        XCTAssertNotIdentical(a, b)

        // not supported by JUnit
        // XCTAssertGreaterThan(1, 0)
        // XCTAssertLessThan(0, 1)
        // XCTAssertLessThanOrEqual(1, 1)
        // XCTAssertGreaterThanOrEqual(1, 1)
    }

    func testRandom() throws {
        XCTAssertNotEqual(Random.shared.randomDouble(), Random.shared.randomDouble(), "random should not repeat")
    }

    func testMath() throws {
        XCTAssertEqual(0.1 + 1.0, 1.1, "math should work")
    }

    func testStringPadding() throws {
        XCTAssertEqual("abc++", "abc".pad(to: 5, with: "+"))
    }

    /// Is this is the Java runtime on Linux
    var isLinuxJava: Bool {
        ProcessInfo.processInfo.isJavaRuntime == true && ProcessInfo.processInfo.osName == "Linux"
    }

    func testProcessInfo() throws {
        print("testProcessInfo: hostName: \(ProcessInfo.processInfo.hostName) osName: \(ProcessInfo.processInfo.osName ?? "")")
        //XCTAssertNotEqual("", ProcessInfo.processInfo.userName)
        XCTAssertNotEqual("", ProcessInfo.processInfo.hostName)
        XCTAssertNotEqual("", ProcessInfo.processInfo.osName)
    }

    func testURLs() throws {
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
        let date: Date = Date()
        XCTAssertNotEqual(0, date.timeIntervalSince1970)

        // let d: Date = Date.create(72348932.0) // SourceKit failed to get an expression's type
        //XCTAssertEqual(72348932.0, d.timeIntervalSince1970)
    }

    func testJSON() throws {
        XCTAssertEqual(JSum.num(1.0), JSum.num(1.0), "JSum should equal")
        XCTAssertNotEqual(JSum.num(1.0), JSum.num(2.0), "JSum should not equal")

        XCTAssertNotEqual(JSum.str("ABC"), JSum.num(1.0))

        // gryphon insert: @kotlinx.serialization.Serializable
        struct JSONDemo : Encodable {
            let num: Int
            let str: String
        }

        let demo: JSONDemo = JSONDemo(num: 123, str: "ABC")
        // note: Kotlin serialization maintains field order in JSON, whereas Swift is either random or ordered by field name
        let expected = "{\"num\":123,\"str\":\"ABC\"}"

        #if GRYPHON
        XCTAssertEqual(expected, try kotlinx.serialization.json.Json.encodeToString(JSONDemo.serializer(), demo))
        #else
        XCTAssertEqual(expected, try encodeJSON(demo))
        #endif
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
