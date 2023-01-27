package CrossFoundation

import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*

@RunWith(org.robolectric.RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest=org.robolectric.annotation.Config.NONE)
internal class CrossFoundationTests {
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
            constructor() {
            }
        }

        val a: SimpleClass = SimpleClass()

        //XCTAssertIdentical(a, a, "a should be a") // erorr on Linux: Type mismatch: inferred type is () -> String but String was expected
        XCTAssertIdentical(a, a)

        val b: SimpleClass = SimpleClass()

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
        XCTAssertEqual(0.1 + 1.0, 1.1, "double addition should work")
    }

    @Test fun testStringPadding() {
        XCTAssertEqual("abc++", "abc".pad(5, "+"))
    }
}
