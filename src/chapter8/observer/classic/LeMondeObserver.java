package chapter8.observer.classic;

import java.util.Objects;

/**
 * Created by ivan on 27.6.17.
 */
public class LeMondeObserver implements Observer {
    @Override
    public void notify(String tweet) {
        if(!Objects.isNull(tweet) && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}
