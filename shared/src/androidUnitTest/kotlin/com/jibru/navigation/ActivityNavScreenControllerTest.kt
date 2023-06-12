package com.jibru.navigation

import androidx.activity.ComponentActivity
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class ActivityNavScreenControllerTest {

    private val activity = mockk<ComponentActivity>(relaxed = true)
    private val controller = ActivityNavScreenController(activity)

    @Test
    fun `close When Activity destroyed Then Nothing`() {
        every { activity.isDestroyed } returns true
        controller.close()
        verify(exactly = 0) { activity.finish() }
    }

    @Test
    fun `close When Activity not destroyed Then calls finish`() {
        every { activity.isDestroyed } returns false
        controller.close()
        verify { activity.finish() }
    }
}
