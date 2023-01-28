package CrossFoundation

import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*

@RunWith(org.robolectric.RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest=org.robolectric.annotation.Config.NONE)
internal class CrossFoundationTests {    //fun XCTUnwrap(a: Any?) = assertNotNull(a)

    fun XCTAssertTrue(a: Boolean) = assertTrue(a)
    fun XCTAssertTrue(a: Boolean, msg: String) = assertTrue(msg, a)
    fun XCTAssertFalse(a: Boolean) = assertFalse(a)
    fun XCTAssertFalse(a: Boolean, msg: String) = assertFalse(msg, a)
    fun XCTAssertNil(a: Any?) = assertNull(a)
    fun XCTAssertNil(a: Any?, msg: String) = assertNull(msg, a)
    fun XCTAssertNotNil(a: Any?) = assertNotNull(a)
    fun XCTAssertNotNil(a: Any?, msg: String) = assertNotNull(msg, a)

    fun XCTAssertEqual(a: Any?, b: Any?) = assertEquals(a, b)
    fun XCTAssertEqual(a: Any?, b: Any?, msg: String) = assertEquals(msg, a, b)
    fun XCTAssertNotEqual(a: Any?, b: Any?) = assertNotEquals(a, b)
    fun XCTAssertNotEqual(a: Any?, b: Any?, msg: String) = assertNotEquals(msg, a, b)
    fun XCTAssertIdentical(a: Any?, b: Any?) = assertSame(a, b)
    fun XCTAssertIdentical(a: Any?, b: Any?, msg: String) = assertSame(msg, a, b)
    fun XCTAssertNotIdentical(a: Any?, b: Any?) = assertNotSame(a, b)
    fun XCTAssertNotIdentical(a: Any?, b: Any?, msg: String) = assertNotSame(msg, a, b)


    @Test fun testTesting() {
        //XCTAssertTrue(true) // error on Linux: Type mismatch: inferred type is () -> Boolean but Boolean was expected
        //XCTAssertFalse(false)
        XCTAssertNil(null)
        XCTAssertNotNil("ABC")
        XCTAssertEqual(1, 1)
        XCTAssertNotEqual("X", "Y")

        open class SimpleClass {
            val value: Int

            constructor(value: Int) {
                this.value = value
            }
        }

        val a: SimpleClass = SimpleClass(value = 1)

        //XCTAssertIdentical(a, a, "a should be a") // erorr on Linux: Type mismatch: inferred type is () -> String but String was expected
        XCTAssertIdentical(a, a)

        val b: SimpleClass = SimpleClass(value = 1)

        //        XCTAssertEqual(a, b)
        XCTAssertNotIdentical(a, b)

        // not supported by JUnit
        // XCTAssertGreaterThan(1, 0)
        // XCTAssertLessThan(0, 1)
        // XCTAssertLessThanOrEqual(1, 1)
        // XCTAssertGreaterThanOrEqual(1, 1)
    }

    @Test fun testRandom() {
        XCTAssertNotEqual(
            Random.shared.randomDouble(),
            Random.shared.randomDouble(),
            "random should not repeat")
    }

    @Test fun testMath() {
        //XCTAssertEqual(0.1 + 1.0, 1.1)
        XCTAssertEqual(1 + 2, 3)
    }

    @Test fun testStringPadding() {
        XCTAssertEqual("abc++", "abc".pad(5, "+"))
    }

    @Test fun testURLs() {
        val url: URL? = URL.init("https://www.example.org/path/to/file.ext")

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

    @Test fun testData() {
        //XCTAssertEqual(0, try Data(contentsOfFile: "/dev/null").count) // parameter name is lost externally
        XCTAssertNotEqual(0, Data.init("/etc/hosts").count)
        XCTAssertNotEqual(0, Data.init(URL.init("/etc/hosts", false)).count)
    }

    @Test fun testUUID() {
        XCTAssertNotEqual(UUID(), UUID())
        XCTAssertNotEqual("", UUID().uuidString)
        println("UUID: ${UUID().uuidString}")
    }

    @Test fun testDate() {
        val date: Date = Date()

        XCTAssertNotEqual(0, date.timeIntervalSince1970)

        // let d: Date = Date.create(72348932.0) // SourceKit failed to get an expression's type
        //XCTAssertEqual(72348932.0, d.timeIntervalSince1970)
    }
}
