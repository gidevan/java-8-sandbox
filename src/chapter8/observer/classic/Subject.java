package chapter8.observer.classic;

/**
 * Created by ivan on 27.6.17.
 */
public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
