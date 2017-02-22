package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import static java.util.stream.Collectors.toList;

/**
 * Created by ivan on 17.2.17.
 */
public class Main {

    public static void main(String[] args) {
        testDistinct();
        getPairsDevidedBy3();
        fizzbuzz();
        fizzbuzzStream();
        reduceExampleIntSum();
        reduceMaxMin();
        countUniqueWords();
    }

    private static void testDistinct() {
        System.out.println();
        String words = "Hello world";
        List<String> result = Arrays.stream(words.split(""))
                .distinct().collect(toList());
        System.out.println(words);
        System.out.println(result);
    }

    /**
     * Two arrays a(a1,a2, ... an) and b(b1,b2, ..., bm). It is necessary to find pairs of them for which sum of them is devided by 3.
     */
    private static void getPairsDevidedBy3() {
        System.out.println();
        List<Integer> a = Arrays.asList(1,2,3,4,5);
        List<Integer> b = Arrays.asList(5,6,7);
        List<int[]> c = a.stream().flatMap(i -> b.stream().filter(j -> (j + i) % 3 == 0).map(j -> new int[]{i, j})).collect(toList());
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    private static void fizzbuzz() {
        System.out.println();
        for(int i = 1; i <=100; i++) {
            if(i % 15 == 0) {
                System.out.print("FIZZBUZZ");
            } else if(i % 3 ==0) {
                System.out.print("FIZZ");
            } else if(i % 5 ==0) {
                System.out.print("BUZZ");
            } else {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }

    private static void fizzbuzzStream() {
        System.out.println();
        List<Integer> a = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            a.add(i);
        }
        List<String> b = a.stream().map(i -> {
            String res = "";
            if(i % 3 ==0) {
                res += "FIZZ";
            }
            if(i % 5 ==0) {
                res+= "BUZZ";
            }
            return res.length() > 0 ? res : String.valueOf(i);
        }).collect(toList());
        System.out.print(b);
    }

    private static void reduceExampleIntSum() {
        int[] numbers = {2, 4, 6, 9};
        int sum = Arrays.stream(numbers).sum();
        int reduceSum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
        int reduceMultiply = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
        int reduceSum1 = Arrays.stream(numbers).reduce(0, Integer :: sum);
        System.out.println("stream.sum(): " + sum);
        System.out.println("stream sum with reduce: " + reduceSum);
        System.out.println("stream multiply with reduce: " + reduceMultiply);
        System.out.println("stream multiply with reduce: " + reduceSum1);

    }

    private static void reduceMaxMin() {
        int[] numbers = {4, 5, 7, 11, 2, 1};
        List<Integer> empty = new ArrayList<>();
        OptionalInt max = Arrays.stream(numbers).reduce(Integer :: max);
        OptionalInt min = Arrays.stream(numbers).reduce(Integer :: min);
        Optional<Integer> emptyMin = empty.stream().reduce(Integer :: min);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("min empty: " + emptyMin);
    }

    private static void countUniqueWords() {
        List<String> words = Arrays.asList("map", "world", "hello", "map", "hello");
        List<String> emptyCollection = new ArrayList<>();
        Optional<Integer> count = words.stream().map(s -> 1).reduce(Integer :: sum);
        Optional<Integer> uniqueCount = words.stream().distinct().map(s -> 1).reduce(Integer :: sum);
        System.out.println("count words: " + count);
        System.out.println("unique words: " + uniqueCount);
        long helloCount = words.stream().filter("hello" :: equals).count();
        long hello1Count = words.stream().filter("hello1" :: equals).count();
        System.out.println("hello words count: " + helloCount);
        System.out.println("hello1 words count: " + hello1Count);
        //Return the first element of collection or "empty" if collection is empty;
        String firstElement = words.stream().findFirst().orElse("empty");
        String firstElementEmpty = emptyCollection.stream().findFirst().orElse("empty");
        System.out.println("First element: " + firstElement);
        System.out.println("First element of empty colledction: " + firstElementEmpty);
    }
}
