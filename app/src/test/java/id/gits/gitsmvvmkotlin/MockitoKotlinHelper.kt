package id.gits.gitsmvvmkotlin

import org.mockito.ArgumentCaptor
import org.mockito.Mockito

/**
 * Created by nizarassegaf on 11/9/2017.
 */

/**
 * Returns Mockito.eq() as nullable type to avoid java.lang.IllegalStateException when
 * null is returned.
 *
 * Generic T is nullable because implicitly bound by `Any?`.
 */
fun <T> eq(obj: T): T = Mockito.eq<T>(obj)

/**
 * Returns Mockito.any() as nullable type to avoid java.lang.IllegalStateException when
 * null is returned.
 */
fun <T> any(): T = Mockito.any<T>()

/**
 * Returns ArgumentCaptor.capture() as nullable type to avoid java.lang.IllegalStateException
 * when null is returned.
 */
fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()

/**
 * Helper function for creating an argumentCaptor in kotlin.
 */
inline fun <reified T : Any> argumentCaptor(): ArgumentCaptor<T> =
        ArgumentCaptor.forClass(T::class.java)

inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)!!