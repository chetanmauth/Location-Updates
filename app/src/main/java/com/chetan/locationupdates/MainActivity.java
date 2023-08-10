package com.chetan.locationupdates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chetan.periodiclocation.GoogleLocationService;
import com.chetan.periodiclocation.LocationUpdater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        LocationUpdater updater=new LocationUpdater(this);
        updater.StartLocationService();
    }
}