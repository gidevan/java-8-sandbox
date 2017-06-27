package chapter8.observer.classic;

import java.util.Objects;

/**
 * Created by ivan on 27.6.17.
 */
public class NYTimesObserver implements Observer {

    @Override
    public void notify(String tweet) {
        if(!Objects.isNull(tweet) && tweet.contains("money")) {
            System.out.println("Breaking news in NY Times! " + tweet);
        }
    }
}
