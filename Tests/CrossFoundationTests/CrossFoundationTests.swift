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

        final class SimpleClass {
            let value: Int
            init(value: Int) { self.value = value }
        }

        let a = SimpleClass(value: 1)
        XCTAssertIdentical(a, a) // on linux types inferred as () -> Any

        let b = SimpleClass(value: 1)
        XCTAssertNotIdentical(a, b)
    }

    func testFileManager() throws {
        let fm: FileManager = FileManager.default
//        let tmp: String = fm.tmpdir // NSTemporaryDirectory()
//        XCTAssertNotEqual("", tmp)
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
        XCTAssertEqual("file.ext", url?.lastPathComponent)
        XCTAssertEqual(false, url?.isFileURL)
    }

    func testData() throws {
        //XCTAssertEqual(0, try Data(contentsOfFile: "/dev/null").count) // parameter name is lost externally
        XCTAssertNotEqual(0, try Data.init(contentsOfFile: "/etc/hosts").count)
        let hostsFile: URL = URL.init(fileURLWithPath: "/etc/hosts", isDirectory: false)
        XCTAssertNotEqual(0, try Data.init(contentsOf: hostsFile).count)

        let url: URL = URL.init(string: "https://www.example.com")!
        let urlData: Data = try Data.init(contentsOf: url)
        print("downloaded url size: \(urlData.count)") // ~1256
        XCTAssertNotEqual(0, urlData.count)

        let url2: URL = URL.init(string: "domains/reserved", relativeTo: URL.init(string: "https://www.iana.org"))!
        let url2Data: Data = try Data.init(contentsOf: url2)
        print("downloaded url2 size: \(url2Data.count)") // ~1256
        XCTAssertNotEqual(0, url2Data.count)

        //let str: String = try String.init(contentsOf: url)
    }

    func testUUID() throws {
        XCTAssertNotEqual(UUID(), UUID())
        XCTAssertNotEqual("", UUID().uuidString)
        print("UUID: \(UUID().uuidString)")

        let uuid: UUID? = UUID.init(uuidString: "d500d1f7-ddb0-439b-ab90-22fdbe5b5790")
        XCTAssertEqual("D500D1F7-DDB0-439B-AB90-22FDBE5B5790", uuid?.uuidString)
    }

    func testDate() throws {
        let date: Date = Date()
        XCTAssertNotEqual(0, date.timeIntervalSince1970)

        // let d: Date = Date.create(72348932.0) // SourceKit failed to get an expression's type
        //XCTAssertEqual(72348932.0, d.timeIntervalSince1970)
    }

    func testJSON() throws {
        // gryphon insert: @kotlinx.serialization.Serializable
        struct JSONDemo : Equatable, Encodable {
            var num: Int
            var str: String
        }

        var demo: JSONDemo = JSONDemo(num: 123, str: "ABC")

        //let encoder = JSONEncoder()
        //try encoder.encode()

        // note: Kotlin serialization maintains field order in JSON, whereas Swift is either random or ordered by field name
        XCTAssertEqual("""
        {"num":123,"str":"ABC"}
        """, try encodeJSON(demo))

        demo.str = "XYZ"

        XCTAssertEqual("""
        {"num":123,"str":"XYZ"}
        """, try encodeJSON(demo))
    }

    func testJSum() throws {
        XCTAssertEqual(JSum.num(1.0), JSum.num(1.0), "JSum should equal")
        XCTAssertNotEqual(JSum.num(1.0), JSum.num(2.0), "JSum should not equal")
        XCTAssertNotEqual(JSum.str("ABC"), JSum.num(1.0))
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
