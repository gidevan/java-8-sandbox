package chapter8.chain.of.responsibility.functional;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by ivan on 27.6.17.
 */
public class Main {

    public static void main(String[] args) {
        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Lucy: " + text;
        UnaryOperator<String> spellingProcessing = (String text) -> text.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerProcessing.andThen(spellingProcessing);
        String result = pipeline.apply("Aren't labda's really sexy?");
        System.out.println(result);

    }
}
