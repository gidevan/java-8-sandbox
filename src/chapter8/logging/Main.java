package chapter8.logging;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ivan on 27.6.17.
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,3,5,6,7,8);
        List<Integer> result = numbers.stream()
                .peek(x -> System.out.println("from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 ==0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("result: ");
        System.out.println(result);
    }
}
