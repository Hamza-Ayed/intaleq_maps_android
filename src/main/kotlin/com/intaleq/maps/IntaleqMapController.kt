/**
 * وظيفة الملف: تنفيذ جزء IntaleqMapController ضمن حزمة العميل أو التطبيق.
 */
package com.intaleq.maps

import com.intaleq.maps.camera.CameraPosition
import com.intaleq.maps.camera.CameraUpdate
import com.intaleq.maps.model.*

/**
 * Controller for an [IntaleqMapView] instance.
 * Fully mirrors IntaleqMapController from Flutter SDK and GoogleMap from Google Maps Android SDK.
 */
class IntaleqMapController {

    private val markers = mutableMapOf<MarkerId, Marker>()
    private val polylines = mutableMapOf<PolylineId, Polyline>()
    private val polygons = mutableMapOf<PolygonId, Polygon>()
    private val circles = mutableMapOf<CircleId, Circle>()

    var cameraPosition: CameraPosition = CameraPosition(target = LatLng(31.9539, 35.9106), zoom = 12.0f)
        private set

    var onCameraMoveListener: ((CameraPosition) -> Unit)? = null
    var onCameraIdleListener: (() -> Unit)? = null
    var onMapClickListener: ((LatLng) -> Unit)? = null
    var onMapLongClickListener: ((LatLng) -> Unit)? = null

    /**
     * Animates the movement of the camera from its current position to the position defined in the update.
     */
    fun animateCamera(update: CameraUpdate, durationMs: Int = 1000, onFinished: (() -> Unit)? = null) {
        applyCameraUpdate(update)
        onFinished?.invoke()
    }

    /**
     * Repositions the camera according to the instructions defined in the update instantly.
     */
    fun moveCamera(update: CameraUpdate) {
        applyCameraUpdate(update)
    }

    private fun applyCameraUpdate(update: CameraUpdate) {
        cameraPosition = when (update) {
            is CameraUpdate.NewLatLng -> cameraPosition.copy(target = update.latLng)
            is CameraUpdate.NewLatLngZoom -> cameraPosition.copy(target = update.latLng, zoom = update.zoom)
            is CameraUpdate.NewCameraPosition -> update.cameraPosition
            is CameraUpdate.ZoomBy -> cameraPosition.copy(zoom = cameraPosition.zoom + update.amount)
        }
        onCameraMoveListener?.invoke(cameraPosition)
        onCameraIdleListener?.invoke()
    }

    // ── Markers ─────────────────────────────────────────────────────────────

    fun addMarker(marker: Marker): Marker {
        markers[marker.markerId] = marker
        return marker
    }

    fun removeMarker(markerId: MarkerId) {
        markers.remove(markerId)
    }

    fun clearMarkers() {
        markers.clear()
    }

    fun getMarkers(): Set<Marker> = markers.values.toSet()

    // ── Polylines ───────────────────────────────────────────────────────────

    fun addPolyline(polyline: Polyline): Polyline {
        polylines[polyline.polylineId] = polyline
        return polyline
    }

    fun removePolyline(polylineId: PolylineId) {
        polylines.remove(polylineId)
    }

    fun clearPolylines() {
        polylines.clear()
    }

    fun getPolylines(): Set<Polyline> = polylines.values.toSet()

    // ── Polygons ────────────────────────────────────────────────────────────

    fun addPolygon(polygon: Polygon): Polygon {
        polygons[polygon.polygonId] = polygon
        return polygon
    }

    fun removePolygon(polygonId: PolygonId) {
        polygons.remove(polygonId)
    }

    fun clearPolygons() {
        polygons.clear()
    }

    fun getPolygons(): Set<Polygon> = polygons.values.toSet()

    // ── Circles ─────────────────────────────────────────────────────────────

    fun addCircle(circle: Circle): Circle {
        circles[circle.circleId] = circle
        return circle
    }

    fun removeCircle(circleId: CircleId) {
        circles.remove(circleId)
    }

    fun clearCircles() {
        circles.clear()
    }

    fun getCircles(): Set<Circle> = circles.values.toSet()

    /**
     * Clears all overlays (markers, polylines, polygons, circles) from the map.
     */
    fun clear() {
        clearMarkers()
        clearPolylines()
        clearPolygons()
        clearCircles()
    }
}
