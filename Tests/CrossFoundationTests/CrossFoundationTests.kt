// =========================================
// GENERATED FILE; EDITS WILL BE OVERWRITTEN
// =========================================
package CrossFoundation
import kotlin.test.*
import org.junit.Test
import org.junit.Assert
import org.junit.runner.RunWith

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*

@RunWith(org.robolectric.RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest=org.robolectric.annotation.Config.NONE)
internal class CrossFoundationTests: XCTestCase {
    @Test fun testTesting() {
        XCTAssertTrue(true)
        XCTAssertFalse(false)
        XCTAssertNil(null)
        XCTAssertNotNil("ABC")
        XCTAssertEqual(1, 1)
        XCTAssertNotEqual("X", "Y")

        class SimpleClass {
            val value: Int

            constructor(value: Int) {
                this.value = value
            }
        }

        val a: SimpleClass = SimpleClass(value = 1)

        XCTAssertIdentical(a, a)

        // on linux types inferred as () -> Any
        val b: SimpleClass = SimpleClass(value = 1)

        XCTAssertNotIdentical(a, b)
    }

    @Test fun testFileManager() {
        val fm: FileManager = FileManager.default
        //        let tmp: String = fm.tmpdir // NSTemporaryDirectory()
        //        XCTAssertNotEqual("", tmp)
    }

    @Test fun testRandom() {
        XCTAssertNotEqual(
            Random.shared.randomDouble(),
            Random.shared.randomDouble(),
            "random should not repeat")
    }

    @Test fun testMath() {
        XCTAssertEqual(0.1 + 1.0, 1.1, "math should work")
    }

    @Test fun testStringPadding() {
        XCTAssertEqual("abc++", "abc".pad(5, "+"))
    }

    open val isLinuxJava: Boolean
        get() = ProcessInfo.processInfo.isJavaRuntime == true && ProcessInfo.processInfo.osName == "Linux"

    @Test fun testProcessInfo() {
        println(
            "testProcessInfo: hostName: ${ProcessInfo.processInfo.hostName} osName: ${ProcessInfo.processInfo.osName ?: ""}")

        //XCTAssertNotEqual("", ProcessInfo.processInfo.userName)
        XCTAssertNotEqual("", ProcessInfo.processInfo.hostName)
        XCTAssertNotEqual("", ProcessInfo.processInfo.osName)
    }

    @Test fun testURLs() {
        val url: URL? = URL.init("https://www.example.org/path/to/file.ext")

        XCTAssertEqual("https://www.example.org/path/to/file.ext", url?.absoluteString)
        XCTAssertEqual("/path/to/file.ext", url?.path)
        XCTAssertEqual("www.example.org", url?.host)
        XCTAssertEqual("ext", url?.pathExtension)
        XCTAssertEqual("file.ext", url?.lastPathComponent)
        XCTAssertEqual(false, url?.isFileURL)
    }

    @Test fun testData() {
        //XCTAssertEqual(0, try Data(contentsOfFile: "/dev/null").count) // parameter name is lost externally
        XCTAssertNotEqual(0, Data.init("/etc/hosts").count)

        val hostsFile: URL = URL.init("/etc/hosts", false)

        XCTAssertNotEqual(0, Data.init(hostsFile).count)

        val url: URL = URL.init("https://www.example.com")!!
        val urlData: Data = Data.init(url)

        println("downloaded url size: ${urlData.count}")

        // ~1256
        XCTAssertNotEqual(0, urlData.count)

        val url2: URL = URL.init("domains/reserved", URL.init("https://www.iana.org"))!!
        val url2Data: Data = Data.init(url2)

        println("downloaded url2 size: ${url2Data.count}")

        // ~1256
        XCTAssertNotEqual(0, url2Data.count)

        //let str: String = try String.init(contentsOf: url)
    }

    @Test fun testUUID() {
        XCTAssertNotEqual(UUID(), UUID())
        XCTAssertNotEqual("", UUID().uuidString)
        println("UUID: ${UUID().uuidString}")

        val uuid: UUID? = UUID.init("d500d1f7-ddb0-439b-ab90-22fdbe5b5790")

        XCTAssertEqual("D500D1F7-DDB0-439B-AB90-22FDBE5B5790", uuid?.uuidString)
    }

    @Test fun testDate() {
        val date: Date = Date()

        XCTAssertNotEqual(0, date.timeIntervalSince1970)

        // let d: Date = Date.create(72348932.0) // SourceKit failed to get an expression's type
        //XCTAssertEqual(72348932.0, d.timeIntervalSince1970)
    }

    @Test fun testJSON() {
        @kotlinx.serialization.Serializable

        data class JSONDemo(
            var num: Int,
            var str: String
        )

        var demo: JSONDemo = JSONDemo(num = 123, str = "ABC")

        //let encoder = JSONEncoder()
        //try encoder.encode()
        // note: Kotlin serialization maintains field order in JSON, whereas Swift is either random or ordered by field name
        XCTAssertEqual("""{"num":123,"str":"ABC"}""", encodeJSON(demo))

        demo.str = "XYZ"

        XCTAssertEqual("""{"num":123,"str":"XYZ"}""", encodeJSON(demo))
    }

    @Test fun testJSum() {
        XCTAssertEqual(JSum.num(1.0), JSum.num(1.0), "JSum should equal")
        XCTAssertNotEqual(JSum.num(1.0), JSum.num(2.0), "JSum should not equal")
        XCTAssertNotEqual(JSum.str("ABC"), JSum.num(1.0))
    }
}



// Mimics the API of XCTest for a JUnit test
// Behavior difference: JUnit assert* thows an exception, but XCTAssert* just reports the failure and continues

private interface XCTestCase {
    fun XCTFail() = Assert.fail()

    fun XCTFail(msg: String) = Assert.fail(msg)

    fun XCTUnwrap(ob: Any?) = { Assert.assertNotNull(ob); ob }
    fun XCTUnwrap(ob: Any?, msg: String) = { Assert.assertNotNull(msg, ob); ob }

    fun XCTAssertTrue(a: Boolean) = Assert.assertTrue(a as Boolean)
    fun XCTAssertTrue(a: Boolean, msg: String) = Assert.assertTrue(msg, a)
    fun XCTAssertFalse(a: Boolean) = Assert.assertFalse(a)
    fun XCTAssertFalse(a: Boolean, msg: String) = Assert.assertFalse(msg, a)

    fun XCTAssertNil(a: Any?) = Assert.assertNull(a)
    fun XCTAssertNil(a: Any?, msg: String) = Assert.assertNull(msg, a)
    fun XCTAssertNotNil(a: Any?) = Assert.assertNotNull(a)
    fun XCTAssertNotNil(a: Any?, msg: String) = Assert.assertNotNull(msg, a)

    fun XCTAssertIdentical(a: Any?, b: Any?) = Assert.assertSame(a, b)
    fun XCTAssertIdentical(a: Any?, b: Any?, msg: String) = Assert.assertSame(msg, a, b)
    fun XCTAssertNotIdentical(a: Any?, b: Any?) = Assert.assertNotSame(a, b)
    fun XCTAssertNotIdentical(a: Any?, b: Any?, msg: String) = Assert.assertNotSame(msg, a, b)

    fun XCTAssertEqual(a: Any?, b: Any?) = Assert.assertEquals(a, b)
    fun XCTAssertEqual(a: Any?, b: Any?, msg: String) = Assert.assertEquals(msg, a, b)
    fun XCTAssertNotEqual(a: Any?, b: Any?) = Assert.assertNotEquals(a, b)
    fun XCTAssertNotEqual(a: Any?, b: Any?, msg: String) = Assert.assertNotEquals(msg, a, b)

    // additional overloads needed for XCTAssert*() which have different signatures on Linux (@autoclosures) than on Darwin platforms (direct values)

    fun XCTUnwrap(ob: () -> Any?) = { val x = ob(); Assert.assertNotNull(x); x }
    fun XCTUnwrap(ob: () -> Any?, msg: () -> String) = { val x = ob(); Assert.assertNotNull(msg(), x); x }

    fun XCTAssertTrue(a: () -> Boolean) = Assert.assertTrue(a())
    fun XCTAssertTrue(a: () -> Boolean, msg: () -> String) = Assert.assertTrue(msg(), a())
    fun XCTAssertFalse(a: () -> Boolean) = Assert.assertFalse(a())
    fun XCTAssertFalse(a: () -> Boolean, msg: () -> String) = Assert.assertFalse(msg(), a())

    fun XCTAssertNil(a: () -> Any?) = Assert.assertNull(a())
    fun XCTAssertNil(a: () -> Any?, msg: () -> String) = Assert.assertNull(msg(), a())
    fun XCTAssertNotNil(a: () -> Any?) = Assert.assertNotNull(a())
    fun XCTAssertNotNil(a: () -> Any?, msg: () -> String) = Assert.assertNotNull(msg(), a())

    fun XCTAssertIdentical(a: () -> Any?, b: () -> Any?) = Assert.assertSame(a(), b())
    fun XCTAssertIdentical(a: () -> Any?, b: () -> Any?, msg: () -> String) = Assert.assertSame(msg(), a(), b())
    fun XCTAssertNotIdentical(a: () -> Any?, b: () -> Any?) = Assert.assertNotSame(a(), b())
    fun XCTAssertNotIdentical(a: () -> Any?, b: () -> Any?, msg: () -> String) = Assert.assertNotSame(msg(), a(), b())

    fun XCTAssertEqual(a: () -> Any?, b: () -> Any?) = Assert.assertEquals(a(), b())
    fun XCTAssertEqual(a: () -> Any?, b: () -> Any?, msg: () -> String) = Assert.assertEquals(msg(), a(), b())
    fun XCTAssertNotEqual(a: () -> Any?, b: () -> Any?) = Assert.assertNotEquals(a(), b())
    fun XCTAssertNotEqual(a: () -> Any?, b: () -> Any?, msg: () -> String) = Assert.assertNotEquals(msg(), a(), b())
}

