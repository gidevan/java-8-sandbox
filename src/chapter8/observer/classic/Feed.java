package chapter8.observer.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 27.6.17.
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
