package io.whereat.mobile;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class OsmDroidMapViewManager extends SimpleViewManager<MapView> {

    public static final String REACT_CLASS = "OsmDroidMapView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected MapView createViewInstance(ThemedReactContext context) {
        MapView map = new MapView(context);

        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        return map;
    }

    @ReactProp(name = "center")
    public void setCenter(MapView map, ReadableMap center) {
        GeoPoint geoCenter = new GeoPoint(center.getDouble("lat"), center.getDouble("lon"));
        map.getController().setCenter(geoCenter);
    }

    @ReactProp(name = "zoom")
    public void setZoom(MapView map, Integer zoom) {
        map.getController().setZoom(zoom);
    }
}
