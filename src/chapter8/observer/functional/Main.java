package chapter8.observer.functional;

import chapter8.observer.classic.Feed;

import java.util.Objects;

/**
 * Created by ivan on 27.6.17.
 */
public class Main {

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver((String tweet) -> {
            if(!Objects.isNull(tweet) && tweet.contains("queen")) {
                System.out.println("Breaking news in Guardian! " + tweet);
            }
        });
        f.registerObserver((String tweet) -> {
            if(!Objects.isNull(tweet) && tweet.contains("money")) {
                System.out.println("Breaking news in NY Times! " + tweet);
            }
        });
        f.registerObserver((String tweet) -> {
            if(!Objects.isNull(tweet) && tweet.contains("cheese")) {
                System.out.println("LeMonde news! " + tweet);
            }
        });

        f.notifyObservers("queen likes cheese!");
    }
}
