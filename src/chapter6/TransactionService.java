package chapter6;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class TransactionService {
    private static final int TRANSACTION_COUNT = 8;
    private static final String CITIES[] = {"Vitebsk", "Minsk", "London", "Paris", "New York"};
    private static final String CURRENCIES[] = {"RU", "EURO", "DOLLAR"};
    private static final int FACTOR = 1000;
    List<Transaction> transactions;

    public TransactionService() {
        transactions = new ArrayList<>();
        transactions.add(new Transaction(UUID.randomUUID().toString(), CITIES[0], CURRENCIES[0], 102.12));
        transactions.add(new Transaction(UUID.randomUUID().toString(), CITIES[1], CURRENCIES[0], 202.50));
        transactions.add(new Transaction(UUID.randomUUID().toString(), CITIES[2], CURRENCIES[1], 301.50));
        transactions.add(new Transaction(UUID.randomUUID().toString(), CITIES[4], CURRENCIES[2], 40.50));
        for(int i = 0; i < TRANSACTION_COUNT; i++) {
            Random random = new Random();
            Transaction transaction = new Transaction(UUID.randomUUID().toString(),
                    CITIES[random.nextInt(CITIES.length)], CURRENCIES[random.nextInt(CURRENCIES.length)], random.nextDouble() * FACTOR);
            transactions.add(transaction);
        }
    }

    public Map<String, List<Transaction>> groupTransactionsByCurrency() {
        Map<String, List<Transaction>> result = transactions.stream().collect(groupingBy(Transaction :: getCurrency));
        return result;
    }

    public Map<String, List<Transaction>> groupTransactionsByCity() {
        Map<String, List<Transaction>> result = transactions.stream().collect(groupingBy(Transaction :: getCity));
        return result;
    }

    public Optional<Transaction> getMaxTransaction() {
        Comparator<Transaction> transactionComparator = Comparator.comparingDouble(Transaction :: getValue);
        return transactions.stream().collect(maxBy(transactionComparator));
    }

    public Optional<Transaction> getMinTransaction() {
        Comparator<Transaction> transactionComparator = Comparator.comparingDouble(Transaction :: getValue);
        return transactions.stream().collect(minBy(transactionComparator));
    }

    public Optional<Double> sumTransactionValues() {
        return transactions.stream().map(Transaction :: getValue).reduce(Double :: sum);
    }

    public Map<String, Double> sumTransactionValuesByCity() {
        Map<String, List<Transaction>> groupByCity = groupTransactionsByCity();
        Map<String, Double> result = new HashMap<>();
        groupByCity.forEach((a, b) -> {
            System.out.println(a);
            System.out.println(b);
            result.put(a, b.stream().map(Transaction :: getValue).reduce(0.0, Double :: sum));
        });
        return result;
    }

    public Map<String, Double> sumTransactionValuesByCurrency() {
        Map<String, List<Transaction>> groupByCity = groupTransactionsByCurrency();
        Map<String, Double> result = new HashMap<>();
        groupByCity.forEach((a, b) -> {
            System.out.println(a);
            System.out.println(b);
            result.put(a, b.stream().map(Transaction :: getValue).reduce(0.0, Double :: sum));
        });
        return result;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

}
