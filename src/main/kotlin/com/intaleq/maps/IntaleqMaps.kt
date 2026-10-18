/**
 * وظيفة الملف: واجهة الدخول أو نقطة تشغيل حزمة IntaleqMaps.
 */
package com.intaleq.maps

import android.content.Context

/**
 * Main entry point for Intaleq Commercial Maps SDK for Android (Kotlin).
 * Compatible with Google Maps SDK structure.
 */
object IntaleqMaps {

    var apiKey: String = ""
        private set

    var baseUrl: String = "https://map-saas.intaleqapp.com"
        private set

    var isInitialized: Boolean = false
        private set

    /**
     * Initializes the Intaleq Maps SDK with your SaaS API Key.
     */
    fun initialize(context: Context, apiKey: String, baseUrl: String = "https://map-saas.intaleqapp.com") {
        this.apiKey = apiKey
        this.baseUrl = baseUrl.trimEnd('/')
        this.isInitialized = true
    }
}
