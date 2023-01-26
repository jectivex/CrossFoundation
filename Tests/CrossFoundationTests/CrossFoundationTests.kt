package CrossSQL

import CrossFoundation.*
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*

import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL


/** Hand-written test case that simply calls `Connection.testDatabase()` */
@RunWith(org.robolectric.RobolectricTestRunner::class)
@org.robolectric.annotation.Config(manifest=org.robolectric.annotation.Config.NONE) // otherwise warns about missing AndroidManifest.xml
class CrossSQLTest {
    @Test
    fun testCrossFoundation() {
        CrossFoundationTestHarness.crossFoundationTests()
    }

    @Test
    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class) // otherwise warning: “CrossSQLTest.kt: (26, 31): This declaration needs opt-in. Its usage should be marked with '@kotlinx.coroutines.ExperimentalCoroutinesApi' or '@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)'”
    fun testDatabaseAsync() = runTest {
        CrossFoundationTestHarness.crossFoundationAsyncTests()
    }
}
