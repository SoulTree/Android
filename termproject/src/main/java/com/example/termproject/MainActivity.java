package com.example.termproject;

import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button MyLocation = (Button) findViewById(R.id.MyLocation);
        Button Statistics = (Button) findViewById(R.id.Statistics);
        Button DBrecord = (Button) findViewById(R.id.DBrecord);
        Button DB_Initial = (Button) findViewById(R.id.DBinitialization);

        final MyLocationListener ml = new MyLocationListener();
        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        MyLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, ml);
                    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0 , ml);
                }
                catch (SecurityException se){}

                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivity(intent);
            }
        });

        Statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        DBrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        DB_Initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    class MyLocationListener implements LocationListener {


        public void onLocationChanged(android.location.Location loc) {

            longitude = loc.getLongitude();
            latitude = loc.getLatitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub

        }

    }
}
