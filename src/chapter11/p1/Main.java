package chapter11.p1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by ivan on 4.7.17.
 */
public class Main {
    private static final int LENGTH = 10;
    private static final int MAX_THREADS = 100;
    private static final String SHOP_PREFIX = "Shop_";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4ParallelStream();
        test5CompletableFuture();
        test6CompletableFutureExecutor();

        System.out.println("end");
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
        long start = System.nanoTime();
        List<String> prices = findPrices(shops, "product1");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("duration: " + duration + " msecs");
        prices.stream().forEach(it -> System.out.println(it));
    }

    /**
     * The same as test3, but in parallel stream.
     */
    private static final void test4ParallelStream() {
        System.out.println();
        System.out.println("test4");
        List<Shop> shops = createShops();
        long start = System.nanoTime();
        List<String> prices = findPricesParallel(shops, "product12");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("duration: " + duration + " msecs");
        prices.stream().forEach(it -> System.out.println(it));
    }

    /**
     * The same as test3, but CompletableFuture is used
     */
    private static final void test5CompletableFuture() {
        System.out.println();
        System.out.println("test5");
        List<Shop> shops = createShops();
        long start = System.nanoTime();
        List<String> prices = findPricesCompletableFuture(shops, "product12");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("duration: " + duration + " msecs");
        prices.stream().forEach(it -> System.out.println(it));
    }

    /**
     * The same as test3, but CompletableFuture and executor is used
     */
    private static final void test6CompletableFutureExecutor() {
        System.out.println();
        System.out.println("test6 (executor). Shop length: " + LENGTH);
        List<Shop> shops = createShops(LENGTH);
        long start = System.nanoTime();
        List<String> prices = findPricesCompletableFutureExecutor(shops, "product12");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("duration: " + duration + " msecs");
        prices.stream().forEach(it -> System.out.println(it));
    }

    private static List<String> findPrices(List<Shop> shops, String product) {
        return shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    private static List<String> findPricesParallel(List<Shop> shops, String product) {
        return shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }


    private static List<Shop> createShops() {
        List<Shop> shops = Arrays.asList(new Shop("TestShop1"), new Shop("tEstShop2"), new Shop("teStShop3"), new Shop("TEstShop4"));
        return shops;
    }

    private static List<Shop> createShops(int length) {
        List<Shop> shops = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            shops.add(new Shop(SHOP_PREFIX + i));
        }
        return shops;
    }

    private static List<String> findPricesCompletableFuture(List<Shop> shops, String product) {
        List<CompletableFuture<String>> futures = shops.stream().map(shop -> CompletableFuture.supplyAsync(
                () -> shop.getName() + " price is " + shop.getPrice(product)
        )).collect(toList());

        return futures.stream().map(CompletableFuture :: join).collect(toList());
    }

    private static List<String> findPricesCompletableFutureExecutor(List<Shop> shops, String product) {
        Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), MAX_THREADS), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread();
                thread.setDaemon(true);
                return thread;
            }
        });
        List<CompletableFuture<String>> futures = shops.stream().map(shop -> CompletableFuture.supplyAsync(
                () -> shop.getName() + " price is " + shop.getPrice(product), executor
        )).collect(toList());
        return futures.stream().map(CompletableFuture :: join).collect(toList());
    }
}
