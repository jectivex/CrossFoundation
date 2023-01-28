package CrossFoundation

import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*

@RunWith(org.robolectric.RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest=org.robolectric.annotation.Config.NONE)
internal class CrossFoundationTests: XCTestCase {
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
        // error on Linux: Type mismatch: inferred type is () -> String but String was expected
        // it seems to be inferring the type as a () -> String
        XCTAssertEqual(1 + 2, 3, "math should work" as String)
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



// Mimics the API of XCTest for a JUnit test
// Behavior difference: JUnit assert* thows an exception, but XCTAssert* just reports the failure and continues

internal interface XCTestCase { }

internal fun XCTestCase.XCTFail() = org.junit.Assert.fail()
internal fun XCTestCase.XCTFail(msg: String) = org.junit.Assert.fail(msg)

internal fun XCTestCase.XCTUnwrap(ob: Any?) = { org.junit.Assert.assertNotNull(ob); ob }
internal fun XCTestCase.XCTUnwrap(ob: Any?, msg: String) = { org.junit.Assert.assertNotNull(msg, ob); ob }

internal fun XCTestCase.XCTAssertTrue(a: Boolean) = org.junit.Assert.assertTrue(a as Boolean)
internal fun XCTestCase.XCTAssertTrue(a: Boolean, msg: String) = org.junit.Assert.assertTrue(msg, a)
internal fun XCTestCase.XCTAssertFalse(a: Boolean) = org.junit.Assert.assertFalse(a)
internal fun XCTestCase.XCTAssertFalse(a: Boolean, msg: String) = org.junit.Assert.assertFalse(msg, a)

internal fun XCTestCase.XCTAssertNil(a: Any?) = org.junit.Assert.assertNull(a)
internal fun XCTestCase.XCTAssertNil(a: Any?, msg: String) = org.junit.Assert.assertNull(msg, a)
internal fun XCTestCase.XCTAssertNotNil(a: Any?) = org.junit.Assert.assertNotNull(a)
internal fun XCTestCase.XCTAssertNotNil(a: Any?, msg: String) = org.junit.Assert.assertNotNull(msg, a)

internal fun XCTestCase.XCTAssertIdentical(a: Any?, b: Any?) = org.junit.Assert.assertSame(a, b)
internal fun XCTestCase.XCTAssertIdentical(a: Any?, b: Any?, msg: String) = org.junit.Assert.assertSame(msg, a, b)
internal fun XCTestCase.XCTAssertNotIdentical(a: Any?, b: Any?) = org.junit.Assert.assertNotSame(a, b)
internal fun XCTestCase.XCTAssertNotIdentical(a: Any?, b: Any?, msg: String) = org.junit.Assert.assertNotSame(msg, a, b)


internal fun XCTestCase.XCTAssertEqual(a: Any?, b: Any?) = org.junit.Assert.assertEquals(a, b)
internal fun XCTestCase.XCTAssertEqual(a: Any?, b: Any?, msg: String) = org.junit.Assert.assertEquals(msg, a, b)
internal fun XCTestCase.XCTAssertEqual(a: Double, b: Double) = org.junit.Assert.assertEquals(a, b)
internal fun XCTestCase.XCTAssertEqual(a: Double, b: Double, msg: String) = org.junit.Assert.assertEquals(msg, a, b)
internal fun XCTestCase.XCTAssertEqual(a: Float, b: Float) = org.junit.Assert.assertEquals(a, b)
internal fun XCTestCase.XCTAssertEqual(a: Float, b: Float, msg: String) = org.junit.Assert.assertEquals(msg, a, b)
internal fun XCTestCase.XCTAssertEqual(a: Long, b: Long) = org.junit.Assert.assertEquals(a, b)
internal fun XCTestCase.XCTAssertEqual(a: Long, b: Long, msg: String) = org.junit.Assert.assertEquals(msg, a, b)
internal fun XCTestCase.XCTAssertEqual(a: Integer, b: Integer) = org.junit.Assert.assertEquals(a, b)
internal fun XCTestCase.XCTAssertEqual(a: Integer, b: Integer, msg: String) = org.junit.Assert.assertEquals(msg, a, b)


internal fun XCTestCase.XCTAssertNotEqual(a: Any?, b: Any?) = org.junit.Assert.assertNotEquals(a, b)
internal fun XCTestCase.XCTAssertNotEqual(a: Any?, b: Any?, msg: String) = org.junit.Assert.assertNotEquals(msg, a, b)
internal fun XCTestCase.XCTAssertNotEqual(a: Double, b: Double) = org.junit.Assert.assertNotEquals(a, b)
internal fun XCTestCase.XCTAssertNotEqual(a: Double, b: Double, msg: String) = org.junit.Assert.assertNotEquals(msg, a, b)
internal fun XCTestCase.XCTAssertNotEqual(a: Float, b: Float) = org.junit.Assert.assertNotEquals(a, b)
internal fun XCTestCase.XCTAssertNotEqual(a: Float, b: Float, msg: String) = org.junit.Assert.assertNotEquals(msg, a, b)
internal fun XCTestCase.XCTAssertNotEqual(a: Long, b: Long) = org.junit.Assert.assertNotEquals(a, b)
internal fun XCTestCase.XCTAssertNotEqual(a: Long, b: Long, msg: String) = org.junit.Assert.assertNotEquals(msg, a, b)
internal fun XCTestCase.XCTAssertNotEqual(a: Integer, b: Integer) = org.junit.Assert.assertNotEquals(a, b)
internal fun XCTestCase.XCTAssertNotEqual(a: Integer, b: Integer, msg: String) = org.junit.Assert.assertNotEquals(msg, a, b)
