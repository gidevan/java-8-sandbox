package chapter7.p3;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by ivan on 15.6.17.
 */
public class Main {

    private static final String TEXT = "  asdf sdf    sdf      sd \n asedfwe \n\n\n\n ff   ";
    private static final String TEXT_WHITESPACE = "   \n\n\n\n   ";


    public static void main(String[] args) {
        System.out.println("Count words iteratively: " + countWordsIteratively(TEXT));
        System.out.println("Count words iteratively(whitespace): " + countWordsIteratively(TEXT_WHITESPACE));

        System.out.println();
        System.out.println("Count words functional style: " + countFunctionalStyle(TEXT));
        System.out.println("Count words functional style (whitespace): " + countFunctionalStyle(TEXT_WHITESPACE));

        System.out.println();
        System.out.println("Count words functional style(parallel): " + countWordsParallel(TEXT));
        System.out.println("Count words functional style (parallel) (whitespace): " + countWordsParallel(TEXT_WHITESPACE));
    }

    private static int countWordsIteratively(String text) {
        int count = 0;
        boolean lastSpace = true;
        for(char c : text.toCharArray()) {
            if(Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if(lastSpace) {
                    count++;
                }
                lastSpace = false;
            }
        }
        return count;
    }

    private static int countFunctionalStyle(String text) {
        Stream<Character> characterStream = IntStream.range(0, text.length()).mapToObj(text :: charAt);
        return countWords(characterStream);
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter :: accumulate, WordCounter :: combine);
        return wordCounter.getCounter();
    }

    private static int countWordsParallel(String text) {
        Spliterator<Character> spliterator = new WordsCounterSpliterator(text);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        return countWords(stream);
    }
}
