package test

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class TestLifecycleOwner : LifecycleOwner {

    private val registry = LifecycleRegistry(this)

    override val lifecycle: Lifecycle = registry

    val observerCount = registry.observerCount

    fun handleEvent(event: Lifecycle.Event) {
        registry.handleLifecycleEvent(event)
    }
}
