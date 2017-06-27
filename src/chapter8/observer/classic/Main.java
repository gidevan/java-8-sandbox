package chapter8.observer.classic;

/**
 * Created by ivan on 27.6.17.
 */
public class Main {

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new LeMondeObserver());
        feed.registerObserver(new NYTimesObserver());
        feed.registerObserver(new GuardianObserver());

        feed.notifyObservers("queen drinks wine");
    }
}
