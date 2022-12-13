package com.example.horizongamestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class Findstores extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    private FusedLocationProviderClient client;
    private SupportMapFragment mapFragment;
    private int REQUEST_CODE = 44;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_findstores);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
        client = LocationServices.getFusedLocationProviderClient(this);

        ImageButton back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(Findstores.this, Homepage.class);
                startActivity(g);
            }
        });

        if (ActivityCompat.checkSelfPermission(Findstores.this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
        } else {
            ActivityCompat.requestPermissions(Findstores.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
        }
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

                            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Current Location");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                            googleMap.addMarker(markerOptions).showInfoWindow();
                        }
                    });
                }
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            }
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        HashMap<LatLng, String> storeLocation = new HashMap<>();
        storeLocation.put(new LatLng(45.531034186659284, -73.54582786758981),"Geekittude");
        storeLocation.put(new LatLng(45.552194681756006, -73.54960441778876), "Retro MTL");
        storeLocation.put(new LatLng(45.54161542972827, -73.61226081881689), "GameStop");
        storeLocation.put(new LatLng(45.5772551520135, -73.6071601791179), "JUST4GAMES");
        storeLocation.put(new LatLng(45.52796078723906, -73.78407250837064), "GameStop");
        storeLocation.put(new LatLng(45.56148177598338, -73.73248676437069), "BestBuy");
        storeLocation.put(new LatLng(45.57069966096283, -73.7537223832513), "GameStop");
        storeLocation.put(new LatLng(45.50364513890918, -73.57135027606894), "GameStop");
        storeLocation.put(new LatLng(45.46435322763869, -73.8321203527554), "GameStop");
        storeLocation.put(new LatLng(45.49379204105903, -73.65560487054637), "GameStop");
        storeLocation.put(new LatLng(45.61114358505355, -73.70008708680982), "GameStop");
        storeLocation.put(new LatLng(45.63033090239578, -73.82089185015101), "GameStop");
        storeLocation.put(new LatLng(45.562227042148905, -73.73243500582542), "La Source");
        storeLocation.put(new LatLng(45.54029275727873, -73.61166104692995), "GameStop");
        storeLocation.put(new LatLng(45.592487061302236, -73.58143380874995), "Stefco video games");
        storeLocation.put(new LatLng(45.59193746327913, -73.58145710214839), "Pro du retro");
        storeLocation.put(new LatLng(45.60140593832828, -73.56058508218536), "Best Buy");
        storeLocation.put(new LatLng(45.49967489990727, -73.57290828893107), "Three Kings Loot inc");
        storeLocation.put(new LatLng(45.68862105264624, -73.4908144042758), "Respawn and Replay inc");
        storeLocation.put(new LatLng(45.50062043687985, -73.42394379390053), "Coin Game Over(Le)");
        storeLocation.put(new LatLng(45.727611658502774, -73.61939218775082), "GameStop");
        storeLocation.put(new LatLng(45.360196214374234, -73.7316237667364), "GameStop");
        storeLocation.put(new LatLng(45.359706254299375, -73.72197763314779), "Microjeux");
        storeLocation.put(new LatLng(45.60634435301812, -73.61678578239277), "The Source");

        for (HashMap.Entry<LatLng, String> pair: storeLocation.entrySet()) {
            map.addMarker(new MarkerOptions().position(pair.getKey()).title(pair.getValue()));
            map.moveCamera(CameraUpdateFactory.newLatLng(pair.getKey()));
        }
    }
}