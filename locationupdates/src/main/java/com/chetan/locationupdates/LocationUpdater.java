package com.chetan.locationupdates;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;

import com.google.android.gms.location.LocationServices;

public class LocationUpdater {

    Context context;

    public LocationUpdater(Context context) {
        this.context = context;
    }

    public void StartLocationService() {
            if (!isLocationServiceRunning()) {
                Intent intent = new Intent(context, GoogleLocationService.class);
                intent.setAction(Constants.ACTION_START_LOCATION_SERVICE);
                context.startService(intent);
                System.out.println("Location service started...");
            }

    }

    private void StopLocationService() {
            Intent intent = new Intent(context, GoogleLocationService.class);
            intent.setAction(Constants.ACTION_STOP_LOCATION_SERVICE);
            context.startService(intent);
            System.out.println("Location service stopped...");
    }

    private boolean isLocationServiceRunning() {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            for (ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)) {
                if (LocationServices.class.getName().equals(service.service.getClassName())) {
                    if (service.foreground) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
