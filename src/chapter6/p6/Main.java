package chapter6.p6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ivan on 8.6.17.
 */
public class Main {

    private static final int[] NUMBERS = {4, 7, 13, 23};
    private static final int CUSTOM_COLLECTOR_NUMBER = 17;

    public static void main(String args[]) {
        partitionPrimes();
    }

    private static final void partitionPrimes() {
        System.out.println();
        for(int number : NUMBERS) {
            System.out.println("Number: "  +  number);
            Map<Boolean, List<Integer>> primes = partitionPrimes(number);
            System.out.println(primes);
        }
        System.out.println();

        System.out.println("Custom  collector. Number: " + CUSTOM_COLLECTOR_NUMBER);
        Map<Boolean, List<Integer>> primes1 = partitionPrimeWithCustomCollector(CUSTOM_COLLECTOR_NUMBER);
        System.out.println(primes1);
    }

    /**
     * Partition first n numbers as prime or not
     * @param n
     * @return
     */
    private static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));

    }

    private static Map<Boolean, List<Integer>> partitionPrimeWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }
}
