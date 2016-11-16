package com.example.mylogger2;

import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    double longitude;
    double latitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button Location = (Button) findViewById(R.id.Location);
        Button ShowDB1 = (Button) findViewById(R.id.ShowDB1);
        final Button Statistic = (Button) findViewById(R.id.Statistic);

        final MyLocationListener ml = new MyLocationListener();
        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try{
                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, ml);
                    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0 , ml);
                }
                catch (SecurityException se){}

                Intent intent = new Intent(getApplicationContext(), MapScreen.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivity(intent);
            }
        });

        ShowDB1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), ShowDB.class);
                startActivity(intent);
            }
        });

        Statistic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Statistics.class);
                startActivity(intent1);
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
