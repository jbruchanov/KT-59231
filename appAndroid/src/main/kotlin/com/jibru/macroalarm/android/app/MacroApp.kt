package com.jibru.macroalarm.android.app

import android.app.Application
import androidx.core.os.bundleOf
import com.google.firebase.analytics.FirebaseAnalytics

class MacroApp : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseAnalytics.getInstance(this).logEvent("AppStart", bundleOf("platform" to "Android"))
    }
}
