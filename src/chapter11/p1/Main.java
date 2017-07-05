package chapter11.p1;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by ivan on 4.7.17.
 */
public class Main {

    public static void main(String[] args) {
        test1();
        test2();
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

    private static void test2() {
        System.out.println();
        System.out.println("test2");
        Shop shop = new Shop("New Shop");

        Future<Double> futurePrice = shop.getPriceAsyncException("product2");
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void test3() {
        System.out.println();
        System.out.println("test3");
        List<Shop> shops = createShops();

    }

    private static void findPrices(List<Shop> shops, String product) {

    }


    private static List<Shop> createShops() {
        List<Shop> shops = Arrays.asList(new Shop("TestShop1"), new Shop("tEstShop2"), new Shop("teStShop3"), new Shop("TEstShop4"));
        return shops;
    }
}
