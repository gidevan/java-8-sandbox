package chapter6;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        TransactionService service = new TransactionService();
        groupTransactionsByCurrencies(service);
        getMinMaxTransactions(service);
        getSumByGroupParameter(service);
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

        System.out.println(sum);
        System.out.println(byCity);
        System.out.println(byCurrency);
    }
}
