package chapter11.p1;


import java.util.concurrent.Future;

/**
 * Created by ivan on 4.7.17.
 */
public class Main {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println();
        System.out.println("test1");
        Shop shop = new Shop("New Shop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("product1");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after: " + invocationTime + " msecs");

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            System.out.println(e);
        }

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after: " + retrievalTime + " msecs");
    }
}
