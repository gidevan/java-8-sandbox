package chapter6;


import chapter4.CaloricLevel;
import chapter4.Dish;
import chapter4.DishBox;
import chapter4.DishType;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        TransactionService service = new TransactionService();
        groupTransactionsByCurrencies(service);
        getMinMaxTransactions(service);
        getSumByGroupParameter(service);

        DishBox dishBox = new DishBox();
        getDishesByType(dishBox);

        getTransactionIds(service);
        findMaxTransactionValueByCity(service);

        findDishesMultilevelGrouping(dishBox);
        findDishesCount(dishBox);
        findMaxDishCaloriesByType(dishBox);
        findMaxCaloriesByType(dishBox);
        findPartitionedByVegetarian(dishBox);
        findVegetarianDishes(dishBox);
        findPartitionedByVegetarianByType(dishBox);
        getMostCaloricPartitionedByVegetarian(dishBox);
    }

    private static void groupTransactionsByCurrencies(TransactionService service) {
        System.out.println();
        List<Transaction> transactions = service.getTransactions();
        Map<String, List<Transaction>> byCurrency = service.groupTransactionsByCurrency();
        Map<String, List<Transaction>> byCity = service.groupTransactionsByCity();
        System.out.println(transactions);
        System.out.println("By Currency:");
        System.out.println(byCurrency);
        System.out.println("By City:");
        System.out.println(byCity);
    }

    private static void getMinMaxTransactions(TransactionService service) {
        System.out.println();
        List<Transaction> transactions = service.getTransactions();
        Optional<Transaction> max = service.getMaxTransaction();
        Optional<Transaction> min = service.getMinTransaction();
        System.out.println(transactions);
        System.out.println(max);
        System.out.println(min);
    }

    private static void getSumByGroupParameter(TransactionService service) {
        System.out.println();
        Optional<Double> sum = service.sumTransactionValues();
        Map<String, Double> byCity = service.sumTransactionValuesByCity();
        Map<String, Double> byCurrency = service.sumTransactionValuesByCurrency();
        Map<String, Double> byCityFunctional = service.sumTransactionValuesByCityFunctional();

        System.out.println(sum);
        System.out.println(byCity);
        System.out.println(byCityFunctional);
        System.out.println(byCurrency);
    }

    private static void getDishesByType(DishBox dishBox) {
        System.out.println();
        Map<DishType, Set<CaloricLevel>> result = dishBox.getDishesByCaloricLevel();
        System.out.println(result);
    }

    private static void getTransactionIds(TransactionService service) {
        System.out.println();
        String ids = service.joinTransactionIds();
        System.out.println(ids);
    }

    private static void findMaxTransactionValueByCity(TransactionService service) {
        System.out.println();
        Map<String, Transaction> result = service.findMaxTransactionValues();
        System.out.println(result);
    }

    private static void findDishesMultilevelGrouping(DishBox dishBox) {
        System.out.println();
        Map<DishType, Map<CaloricLevel, List<Dish>>> result = dishBox.findDishesMultilevelGrouping();
        System.out.println(result);
    }

    private static void findDishesCount(DishBox dishBox) {
        System.out.println();
        Map<DishType, Long> dishCount = dishBox.findDishTypesCount();
        System.out.println(dishCount);
    }

    private static void findMaxDishCaloriesByType(DishBox dishBox) {
        System.out.println();
        Map<DishType, Optional<Dish>> result = dishBox.findMaxCaloriesByTypeOptional();
        System.out.println(result);
    }

    private static void findMaxCaloriesByType(DishBox dishBox) {
        System.out.println();
        Map<DishType, Dish> result = dishBox.findMaxCaloriesByType();
        System.out.println(result);
    }

    private static void findPartitionedByVegetarian(DishBox dishBox) {
        System.out.println();
        Map<Boolean, List<Dish>> result = dishBox.partitionedByVegetarianMenu();
        System.out.println(result);
    }

    private static void findVegetarianDishes(DishBox dishBox) {
        System.out.println();
        List<Dish> result = dishBox.getVegetarianDishes();
        System.out.println(result);
    }

    private static void findPartitionedByVegetarianByType(DishBox dishBox) {
        System.out.println();
        Map<Boolean, Map<DishType, List<Dish>>> result = dishBox.findPartitionedByVegetarianByType();
        System.out.println(result);
    }

    private static void getMostCaloricPartitionedByVegetarian(DishBox dishBox) {
        System.out.println();
        Map<Boolean, Dish> result = dishBox.getMostCaloricPartitionedByVegetarian();
        System.out.println(result);
    }
}
