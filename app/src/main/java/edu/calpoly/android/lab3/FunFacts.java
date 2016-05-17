package edu.calpoly.android.lab3;

import android.content.Intent;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by ashleydattalo on 5/16/16.
 */
public class FunFacts {
    private double miles, mileFactNum;
    private double calories, calorieFactNum;
    private String finalFact, calorieFactStr, mileFactStr;

    HashMap<Integer, String> foods;
    HashMap<String, Double> calorieConv;


    HashMap<Integer, String> places;
    HashMap<String, Double> distConv;

    public FunFacts(double miles, double calories) {
        this.miles = miles;
        this.calories = calories;
        foods = new HashMap<Integer, String>();
        calorieConv = new HashMap<String, Double>();
        places = new HashMap<Integer, String>();
        distConv = new HashMap<String, Double>();
        setUpCalorieMaps();
        setUpMileMaps();
        generateCalorieFact();
        generateMileFact();
    }

    private void setUpMileMaps() {
        String whiteHouse = "the length of the White House";
        String eiffelTower = "the height of the Eiffel Tower";

        places.put(0, whiteHouse);
        places.put(1, eiffelTower);

        distConv.put(whiteHouse, 85.6);
        distConv.put(eiffelTower, 984.0);
    }

    private void generateMileFact() {
        double feetInMile = 5280;
        double feetRan = miles * feetInMile;

        Random r = new Random();
        int random = r.nextInt(places.size());

        mileFactStr = places.get(random);
        mileFactNum = feetRan / distConv.get(mileFactStr);
    }

    private void setUpCalorieMaps() {
        String frenchFry = "McDonald's French Fries";
        String donut = "Donuts";
        String reese = "Reese Cups";

        foods.put(0, frenchFry);
        foods.put(1, donut);
        foods.put(2, reese);

        calorieConv.put(frenchFry, 6.5);
        calorieConv.put(donut, 195.0);
        calorieConv.put(reese, 87.0);
    }

    private void generateCalorieFact() {
        Random r = new Random();
        int random = r.nextInt(foods.size());

        calorieFactStr = foods.get(random);
        calorieFactNum = (1 / calorieConv.get(calorieFactStr)) * calories;
    }

    public String getFacts() {

        DecimalFormat df = new DecimalFormat("#.##");

        String milesStr = "You ran " + miles + " miles OR "+ mileFactStr + " " + df.format(mileFactNum) + " times!";
        String calStr = "You burned " + calories + " calories OR " + df.format(calorieFactNum) + " " + calorieFactStr + "!";

        return "Congratulations! " + milesStr + " " + calStr;
    }

    public String getRandomFacts() {
        DecimalFormat df = new DecimalFormat("#.##");

        String milesStr = "You should run " + miles + " miles OR "+ mileFactStr + " " + df.format(mileFactNum) + " times!";
        String calStr = "You should burn " + calories + " calories OR " + df.format(calorieFactNum) + " " + calorieFactStr + "!";

        return "Here's a workout!\n" + milesStr + "\n" + calStr;
    }

}
