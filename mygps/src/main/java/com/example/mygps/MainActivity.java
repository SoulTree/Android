package com.example.mygps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.database.sqlite.*;



public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SQLiteDatabase db = this.openOrCreateDatabase("myfriendsDB2", MODE_PRIVATE, null);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        final MyLocationListener ml = new MyLocationListener();
        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, ml);
                    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, ml);

                } catch (SecurityException se) {
                }
            }
        });

        button2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

    }

    class MyLocationListener implements LocationListener {

        public void onLocationChanged(Location loc) {
            final DBManager dbManager = new DBManager(getApplicationContext(), "MyGPS.db", null, 1);
            double longitude = loc.getLongitude();
            double latitude = loc.getLatitude();
            String msg = "Longtitude : " + longitude + "\nLatitude : " + latitude;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            intent.putExtra("Longtitude" , longitude);
            intent.putExtra("Latitude", latitude);

            int count = 0;
           while (true)
           {
               dbManager.insert("insert into MyGPS values(null, '" + longitude + "', " + latitude + ");");
               count++;
               if(count == 24)
                   break;
           }
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

