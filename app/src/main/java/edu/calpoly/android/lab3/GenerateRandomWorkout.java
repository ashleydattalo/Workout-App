package edu.calpoly.android.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomWorkout extends AppCompatActivity {
    protected File path;
    protected Button settings, home, save, generate;
    protected TextView randomWorkout;
    protected FunFacts funFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_random_workout);
        path = this.getApplicationContext().getFilesDir();
        generate = (Button) findViewById(R.id.generateRandomWorkout);
        randomWorkout = (TextView) findViewById(R.id.randomWorkout);

        addListeners();
    }

    protected void addListeners() {
        home = (Button) findViewById(R.id.home);
        save = (Button) findViewById(R.id.saveWorkout);

        home.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(GenerateRandomWorkout.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        save.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                String string = funFact.getFacts();
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

            }
        });

        generate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int miles, calories;
                Random random = new Random();
                miles = random.nextInt(15);
                calories = random.nextInt(2000);

                funFact = new FunFacts(miles, calories);
                String string = funFact.getRandomFacts();

                randomWorkout.setText(string);

                save.setVisibility(View.VISIBLE);
            }
        });

    }

}