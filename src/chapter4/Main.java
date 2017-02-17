package chapter4;

import java.util.List;

/**
 * Created by ivan on 17.2.17.
 */
public class Main {

    public static void main(String[] args) {
        DishBox dishBox = new DishBox();
        dishesLess200(dishBox);

    }

    private static void dishesLess200(DishBox dishBox) {
        List<Dish> dishes = dishBox.getDishes();
        List<String> dishLess200 = dishBox.getDishNamesCaloriesLess200();
        System.out.println(dishes);
        System.out.println(dishLess200);
    }
}
