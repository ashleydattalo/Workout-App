package edu.calpoly.android.lab3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import edu.calpoly.android.lab3.R;

public class MainActivity extends Activity {
    Button viewWorkouts, addWorkout, settings, generateRandomWorkout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.main_layout);

        // Locate the button in activity_main.xml
        viewWorkouts = (Button) findViewById(R.id.ViewSavedWorkouts);

        // Capture button clicks
        viewWorkouts.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        SavedWorkouts.class);
                startActivity(myIntent);
            }
        });

        addWorkout = (Button) findViewById(R.id.AddWorkout);

        // Capture button clicks
        addWorkout.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        AddWorkout.class);
                startActivity(myIntent);
            }
        });

        settings = (Button) findViewById(R.id.settings);

        settings.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Settings.class);
                startActivity(myIntent);
            }
        });

        generateRandomWorkout = (Button) findViewById(R.id.generateRandomWorkout);

        generateRandomWorkout.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        GenerateRandomWorkout.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_layout, menu);
        return true;
    }
}