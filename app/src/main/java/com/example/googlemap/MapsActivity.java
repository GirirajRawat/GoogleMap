package com.example.googlemap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<LatitudeLogitude> latlngs = new ArrayList<>();
        latlngs.add(new LatitudeLogitude(27.708074, 85.328155, "Film Directors Nepal"));
        latlngs.add(new LatitudeLogitude(27.70482, 85.3293997, "Gopal dai ko chatpat"));
        latlngs.add(new LatitudeLogitude(27.707509, 85.326814, "Charkhal Adda"));
        latlngs.add(new LatitudeLogitude(27.724150, 85.319698, "Samakhusi"));

        CameraUpdate center, zoom;
        for (int i = 0; i < latlngs.size(); i++){
            center = CameraUpdateFactory.newLatLng(new LatLng(latlngs.get(i).getLat(),
                  latlngs.get(i).getLon()));
            zoom = CameraUpdateFactory.zoomTo(16);

            mMap.addMarker(new MarkerOptions().position(new LatLng(latlngs.get(i).getLat(),
                   latlngs.get(i).getLon())).title(latlngs.get(i).getMarker()));

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);

        }



    }
}
