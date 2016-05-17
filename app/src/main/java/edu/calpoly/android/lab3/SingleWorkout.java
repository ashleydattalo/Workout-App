package edu.calpoly.android.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SingleWorkout extends AppCompatActivity {
    protected File path;
    protected Button backToAddWorkoutPage;
    protected TextView singleWorkout;
    protected boolean savedWorkouts, addWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_workout);
        path = this.getApplicationContext().getFilesDir();

        singleWorkout = (TextView) findViewById(R.id.singleWorkout);
        String workoutText = intent.getExtras().getString("singleWorkout");
        singleWorkout.setText(workoutText);

        savedWorkouts = false;
        addWorkout = false;

        savedWorkouts = intent.getBooleanExtra("savedWorkouts", false);
        addWorkout = intent.getBooleanExtra("addWorkout", false);

        Log.v("adattalo", "savedWorkout: " + savedWorkouts);
        Log.v("adattalo", "addWorkout: " + addWorkout);

        initAddListeners();
    }

    protected void initAddListeners() {
        backToAddWorkoutPage = (Button) findViewById(R.id.back);

        backToAddWorkoutPage.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (savedWorkouts == true) {
                    Intent intent = new Intent(SingleWorkout.this,
                            SavedWorkouts.class);
                    startActivity(intent);
                }
                if (addWorkout == true) {
                    Intent intent = new Intent(SingleWorkout.this,
                            AddWorkout.class);
                    startActivity(intent);
                }
            }
        });
    }

}