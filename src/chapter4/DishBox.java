package chapter4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

/**
 * Created by ivan on 17.2.17.
 */
public class DishBox {

    private static final int DISHES_COUNT = 10;
    private static final int FACTOR = 50;

    private List<Dish> dishes;

    public DishBox() {
        dishes = new ArrayList<>();
        dishes.add(new Dish("Dish1", 100, DishType.FISH));
        dishes.add(new Dish("Dish2", 150, DishType.VEGETARIAN));
        dishes.add(new Dish("Dish3", 350, DishType.FISH));
        dishes.add(new Dish("Dish4", 200, DishType.MEAT));
        dishes.add(new Dish("salad", 75, DishType.VEGETARIAN));
        dishes.add(new Dish("pork", 175, DishType.MEAT));
        dishes.add(new Dish("salmon", 200, DishType.FISH));
        for(int i = 0; i < DISHES_COUNT; i++) {
            DishType[] types = DishType.values();
            dishes.add(new Dish("name_" + i, new Random().nextInt(5) * FACTOR, DishType.values()[new Random().nextInt(types.length)]));
        }
    }

    public List<String> getDishNamesCaloriesLess200() {
        return dishes.stream().filter(dish -> dish.getCalories() < 200).map(Dish::getName).collect(Collectors.toList());
    }

    public Map<DishType, Set<CaloricLevel>> getDishesByCaloricLevel() {
        return dishes.stream().collect(groupingBy(Dish :: getDishType,
                mapping(dish -> {
                    if(dish.getCalories() < 150) {
                        return CaloricLevel.DIET;
                    } else if(dish.getCalories() < 250) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
        }, toSet())));
    }

    public Map<DishType, Map<CaloricLevel, List<Dish>>> findDishesMultilevelGrouping() {
        return dishes.stream().collect(groupingBy(Dish :: getDishType, groupingBy(dish -> {
            if(dish.getCalories() < 150) {
                return CaloricLevel.DIET;
            } else if(dish.getCalories() < 250) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        })));
    }

    public Map<DishType, Long> findDishTypesCount() {
        return dishes.stream().collect(groupingBy(Dish :: getDishType, counting()));
    }

    public Map<DishType, Optional<Dish>> findMaxCaloriesByTypeOptional() {
        return dishes.stream().collect(groupingBy(Dish :: getDishType, maxBy(Comparator.comparingInt(Dish :: getCalories))));
    }

    public Map<DishType, Dish> findMaxCaloriesByType() {
        return dishes.stream().collect(groupingBy(Dish :: getDishType, collectingAndThen( maxBy(Comparator.comparingInt(Dish :: getCalories)), Optional :: get)));
    }

    public Map<Boolean, List<Dish>> partitionedByVegetarianMenu() {
        return dishes.stream().collect(partitioningBy(Dish :: isVegetarian));
    }

    public List<Dish> getVegetarianDishes() {
        return  dishes.stream().filter(Dish :: isVegetarian).collect(Collectors.toList());
    }

    public Map<Boolean, Map<DishType, List<Dish>>> findPartitionedByVegetarianByType() {
        return dishes.stream().collect(partitioningBy(Dish :: isVegetarian, groupingBy(Dish :: getDishType)));
    }

    public Map<Boolean, Dish> getMostCaloricPartitionedByVegetarian() {
        return dishes.stream().collect(partitioningBy(Dish :: isVegetarian, collectingAndThen(maxBy(Comparator.comparingInt(Dish :: getCalories)), Optional :: get)));
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
