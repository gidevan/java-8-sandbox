package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ivan on 17.2.17.
 */
public class Main {

    private static final int N = 5;
    private static final int M = 3;
    public static void main(String[] args) {
        testDistinct();
        getPairsDevidedBy3();
        fizzbuzz();
        fizzbuzzStream();
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
}
