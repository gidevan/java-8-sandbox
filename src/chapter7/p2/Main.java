package chapter7.p2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * Created by ivan on 15.6.17.
 */
public class Main {

    private static final long FORK_JOIN_VALUES[] = {5, 100, 20_000};

    public static void main(String[] args) {
        forkJoinSum();
    }

    private static void forkJoinSum() {
        System.out.println();
        System.out.println("Fork join sum:");
        for(long value : FORK_JOIN_VALUES) {
            System.out.println("value: " + value);
            System.out.println("sum: " + forkJoinSum(value));
        }
    }

    private static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
