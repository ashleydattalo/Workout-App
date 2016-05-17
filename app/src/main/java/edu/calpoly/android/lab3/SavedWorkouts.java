package edu.calpoly.android.lab3;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.calpoly.android.lab3.R;
import edu.calpoly.android.lab3.MainActivity;

public class SavedWorkouts extends AppCompatActivity {
    protected File path;
    private ListView lv;
    protected Button settings, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("adattalo", "made it here");
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_workouts);
        path = this.getApplicationContext().getFilesDir();
        getData();

        addListeners();
    }

    protected void getData() {
        Log.v("adattalo", "populating");

        File file = new File(path, "myFile.txt");

        Log.v("adattalo", path.toString());

        List<String> data = new ArrayList<String>();

        if(file.exists()) {
            Log.v("adattalo", "File exists");

            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(fr);
            try {
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = br.readLine()) != null) {
                    Workout workout = new Workout();
                    workout.setTotalWorkout(line);
                    sb.append(line).append("\n");
                    data.add(line + "\n");
                }
                br.close();
                Log.v("adattalo", sb + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fillData(data);
    }

    protected void fillData(List<String> data) {
        lv = (ListView) findViewById(R.id.savedWorkouts);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data );

        lv.setAdapter(arrayAdapter);
    }

    protected void addListeners() {
        settings = (Button) findViewById(R.id.settings);
        home = (Button) findViewById(R.id.home);
        lv = (ListView) findViewById(R.id.savedWorkouts);

        settings.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(SavedWorkouts.this,
                        Settings.class);
                startActivity(myIntent);
            }
        });

        home.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(SavedWorkouts.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {

                // We know the View is a TextView so we can cast it
                TextView clickedView = (TextView) view;

                String thisTextView = clickedView.getText().toString();

                Intent myIntent = new Intent(SavedWorkouts.this,
                        SingleWorkout.class);
                myIntent.putExtra("singleWorkout", thisTextView);
                myIntent.putExtra("addWorkout", false);
                myIntent.putExtra("savedWorkouts", true);
                startActivity(myIntent);
            }
        });
    }
}

