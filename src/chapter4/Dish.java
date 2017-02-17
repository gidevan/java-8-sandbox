package chapter4;

/**
 * Created by ivan on 17.2.17.
 */
public class Dish {

    private String name;
    private int calories;

    public Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "[name: " + name + ", calories: " + calories + "]";
    }
}
