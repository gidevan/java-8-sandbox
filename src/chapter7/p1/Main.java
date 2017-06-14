package chapter7.p1;

import java.util.stream.Stream;

/**
 * Created by ivan on 14.6.17.
 */
public class Main {
    private static final long COUNT = 12L;

    public static void main(String[] args) {
        parallelSum(COUNT);
    }

    private static void parallelSum(long n) {
        System.out.println("parallel sum:");
        long result = Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
        System.out.println("result: " + result
        );
    }
}
