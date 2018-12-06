package id.gits.gitsmvvmkotlin

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 * 2)
    }

    @Test
    fun addition_isNotCorrect() {
        assertEquals(4, 2 + 0)
    }

    @Test(expected = NullPointerException::class)
    fun nullStringTest() {
        val str: String? = null
        assertTrue(str!!.isEmpty())
    }

}
