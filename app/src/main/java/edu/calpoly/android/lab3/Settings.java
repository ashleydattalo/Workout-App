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
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import edu.calpoly.android.lab3.R;
import edu.calpoly.android.lab3.MainActivity;

public class Settings extends AppCompatActivity {
    protected File path;
    Button deleteWorkouts, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        path = this.getApplicationContext().getFilesDir();

        addListeners();

    }

    protected void deleteWorkouts() {
        File file = new File(path, "myFile.txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }

    protected void addListeners() {
        home = (Button) findViewById(R.id.home);
        deleteWorkouts = (Button) findViewById(R.id.deleteWorkouts);

        home.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(Settings.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        deleteWorkouts.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                deleteWorkouts();
            }
        });
    }

}