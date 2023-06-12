package com.jibru.macroalarm.android.app

import android.app.Application
import android.content.Context
import androidx.core.os.bundleOf
import com.google.firebase.analytics.FirebaseAnalytics
import com.jibru.core.ServiceProvider
import kotlin.reflect.KClass

class MacroApp : Application(), ServiceProvider {

    init {
        ServiceProvider.setServiceProviderDelegate(this)
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseAnalytics.getInstance(this).logEvent("AppStart", bundleOf("platform" to "Android"))
    }

    override fun <T : Any> provide(clazz: KClass<T>): T {
        //TODO DI:
        @Suppress("UNCHECKED_CAST")
        return when (clazz) {
            Application::class -> this
            Context::class -> this
            else -> throw IllegalArgumentException("Unsupported yet!")
        } as T
    }
}
