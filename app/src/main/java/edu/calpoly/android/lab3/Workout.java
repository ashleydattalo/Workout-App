package edu.calpoly.android.lab3;

/**
 * Created by ashleydattalo on 4/22/16.
 */
public class Workout {
    protected int miles;
    protected int calories;
    protected int elevation;
    protected String totalWorkout;

    public Workout() {
        miles = 0;
        calories = 0;
        elevation = 0;
        totalWorkout = "";
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public void setTotalWorkout(String totalWorkout) {
        this.totalWorkout = totalWorkout;
    }

    public int getMiles() { return  miles; }

    public int getCalories() {
        return calories;
    }

    public int getElevation() {
        return elevation;
    }

    public String getTotalWorkout() {
        return totalWorkout;
    }

}
