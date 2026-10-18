/**
 * وظيفة الملف: تنفيذ جزء IntaleqStyles ضمن حزمة العميل أو التطبيق.
 */
package com.intaleq.maps.styles

import com.intaleq.maps.IntaleqMaps

/**
 * Predefined map visual styles for the Intaleq Map SDK.
 * Mirrors IntaleqStyles from Flutter SDK.
 */
object IntaleqStyles {
    val DARK: String
        get() {
            val keyParam = if (IntaleqMaps.apiKey.isNotEmpty()) "?key=${IntaleqMaps.apiKey}" else ""
            return "${IntaleqMaps.baseUrl}/style-dark.json$keyParam"
        }

    val LIGHT: String
        get() {
            val keyParam = if (IntaleqMaps.apiKey.isNotEmpty()) "?key=${IntaleqMaps.apiKey}" else ""
            return "${IntaleqMaps.baseUrl}/style.json$keyParam"
        }

    val NORMAL: String
        get() {
            val keyParam = if (IntaleqMaps.apiKey.isNotEmpty()) "?key=${IntaleqMaps.apiKey}" else ""
            return "${IntaleqMaps.baseUrl}/style.json$keyParam"
        }

    val SATELLITE: String
        get() {
            val keyParam = if (IntaleqMaps.apiKey.isNotEmpty()) "?key=${IntaleqMaps.apiKey}" else ""
            return "${IntaleqMaps.baseUrl}/style-satellite.json$keyParam"
        }

    val OUTDOORS: String
        get() {
            val keyParam = if (IntaleqMaps.apiKey.isNotEmpty()) "?key=${IntaleqMaps.apiKey}" else ""
            return "${IntaleqMaps.baseUrl}/style-tourism.json$keyParam"
        }

    val TERRAIN: String
        get() {
            val keyParam = if (IntaleqMaps.apiKey.isNotEmpty()) "?key=${IntaleqMaps.apiKey}" else ""
            return "${IntaleqMaps.baseUrl}/style-3d-terrain.json$keyParam"
        }
}

enum class IntaleqMapType {
    NONE,
    NORMAL,
    LIGHT,
    SATELLITE,
    DARK,
    TERRAIN
}
