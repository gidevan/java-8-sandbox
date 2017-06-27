package chapter8.observer.classic;

import java.util.Objects;

/**
 * Created by ivan on 27.6.17.
 */
public class GuardianObserver implements Observer {
    @Override
    public void notify(String tweet) {
        if(!Objects.isNull(tweet) && tweet.contains("queen")) {
            System.out.println("Breaking news in Guardian! " + tweet);
        }
    }
}
