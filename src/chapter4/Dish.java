package chapter4;

/**
 * Created by ivan on 17.2.17.
 */
public class Dish {

    private String name;
    private int calories;
    private DishType dishType;

    public Dish(String name, int calories, DishType dishType) {
        this.name = name;
        this.calories = calories;
        this.dishType = dishType;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public DishType getDishType() {
        return dishType;
    }

    public boolean isVegetarian() {
        return DishType.VEGETARIAN == dishType;
    }

    @Override
    public String toString() {
        return "[name: " + name + ", calories: " + calories + "]";
    }
}
