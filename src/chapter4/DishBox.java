package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by ivan on 17.2.17.
 */
public class DishBox {

    private static final int DISHES_COUNT = 10;
    private static final int FACTOR = 50;

    private List<Dish> dishes;

    public DishBox() {
        dishes = new ArrayList<>();
        dishes.add(new Dish("Dish1", 100));
        dishes.add(new Dish("Dish2", 150));
        dishes.add(new Dish("Dish3", 350));
        dishes.add(new Dish("Dish4", 200));
        for(int i = 0; i < DISHES_COUNT; i++) {
            dishes.add(new Dish("name_" + i, new Random().nextInt(5) * FACTOR));
        }
    }

    public List<String> getDishNamesCaloriesLess200() {
        return dishes.stream().filter(dish -> dish.getCalories() < 200).map(Dish::getName).collect(Collectors.toList());
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
