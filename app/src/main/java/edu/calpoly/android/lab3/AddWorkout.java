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

public class AddWorkout extends AppCompatActivity {
    protected Button addWorkoutButton;
    protected File path;
    protected Button settings, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_workout);
        path = this.getApplicationContext().getFilesDir();
        addWorkoutButton = (Button)findViewById(R.id.addWorkoutButton);
        initAddListeners();
        addListeners();
    }

    protected void initAddListeners() {
        addWorkoutButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TextView textViewMiles = (TextView) findViewById(R.id.miles);
                String miles = textViewMiles.getText().toString();

                TextView textViewCalories = (TextView) findViewById(R.id.calories);
                String calories = textViewCalories.getText().toString();


                if (miles != null && calories != null) {

                    FunFacts facts = new FunFacts(Double.parseDouble(miles), Double.parseDouble(calories));
                    String string = facts.getFacts();

                    File file = new File(path, "myFile.txt");

                    try {
                        BufferedWriter buf = new BufferedWriter(new FileWriter(file, true));
                        buf.write(string);
                        buf.newLine();
                        buf.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    textViewCalories.setText("");
                    textViewMiles.setText("");

                    viewSingleWorkout(string);
                }
                else {

                }
            }
        });
    }

    protected void viewSingleWorkout(String workoutText) {
        Intent myIntent = new Intent(AddWorkout.this,
                SingleWorkout.class);
        myIntent.putExtra("singleWorkout", workoutText);
        myIntent.putExtra("addWorkout", true);
        myIntent.putExtra("saveWorkout", false);
        startActivity(myIntent);
    }

    protected void addListeners() {
        settings = (Button) findViewById(R.id.settings);
        home = (Button) findViewById(R.id.home);

        settings.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(AddWorkout.this,
                        Settings.class);
                startActivity(myIntent);
            }
        });

        home.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(AddWorkout.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });
    }

}