package com.example.surface.calculation01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Average = (Button)findViewById(R.id.Average);
        Button Minimum = (Button)findViewById(R.id.Minimum);
        final TextView printAverage = (TextView)findViewById(R.id.printAverage);
        final TextView printMinimum = (TextView)findViewById(R.id.printMinimum);

        Average.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                getAverage average = new getAverage();
                String a = String.valueOf(average.getResult());
                printAverage.setText("Average Value = " + a);
            }
        });

        Minimum.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                getMinimum minimum = new getMinimum();
                String m = String.valueOf(minimum.getResult());
                printMinimum.setText("Minimum Value = " + m);
            }
        });
    }
}
