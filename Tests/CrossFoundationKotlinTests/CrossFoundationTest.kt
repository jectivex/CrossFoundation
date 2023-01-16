package CrossFoundation

import kotlin.test.Test
import kotlin.test.assertTrue

class CrossFoundationTest {
    @Test fun someCrossFoundationTest() {
        val crossFoundation = CrossFoundation()
        assertTrue(crossFoundation.importantFilesExist())
    }
}
