package CrossFoundation

import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*

@RunWith(org.robolectric.RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest=org.robolectric.annotation.Config.NONE)
internal class CrossFoundationTests {
    @Test fun testTesting() {
        assertTrue(true)
        assertFalse(false)
        assertNull(null)
        assertNotNull("ABC")
        assertEquals(1, 1)
        assertNotEquals("X", "Y")
        assertSame(this, this)
        assertNotSame(this, CrossFoundationTests())

        // not supported by JUnit
        // XCTAssertGreaterThan(1, 0)
        // XCTAssertLessThan(0, 1)
        // XCTAssertLessThanOrEqual(1, 1)
        // XCTAssertGreaterThanOrEqual(1, 1)
    }

    @Test fun testRandom() {
        assertNotEquals(Random.shared.randomDouble(), Random.shared.randomDouble())
    }

    @Test fun testStringPadding() {
        assert("abc".pad(5, "+") == "abc++")
    }
}
