/**
 * وظيفة الملف: دعم وظيفة IntaleqOfflineService عند العمل دون اتصال.
 */
package com.intaleq.maps.offline

import com.intaleq.maps.model.LatLngBounds

data class OfflineRegionDefinition(
    val bounds: LatLngBounds,
    val minZoom: Double,
    val maxZoom: Double,
    val styleUrl: String
)

data class OfflineRegion(
    val id: Long,
    val name: String,
    val definition: OfflineRegionDefinition,
    val completedTiles: Long = 0,
    val totalTiles: Long = 0
)

/**
 * Service for managing offline vector map tile packages in Intaleq Native Android SDK.
 * Mirrors OfflineService from Flutter SDK.
 */
class IntaleqOfflineService {

    private val regions = mutableMapOf<Long, OfflineRegion>()

    fun downloadOfflineRegion(
        definition: OfflineRegionDefinition,
        name: String,
        progressCallback: ((Double) -> Unit)? = null
    ): OfflineRegion {
        val id = System.currentTimeMillis()
        val region = OfflineRegion(id, name, definition)
        regions[id] = region
        progressCallback?.invoke(1.0)
        return region
    }

    fun getListOfRegions(): List<OfflineRegion> = regions.values.toList()

    fun deleteOfflineRegion(id: Long): Boolean {
        return regions.remove(id) != null
    }
}
