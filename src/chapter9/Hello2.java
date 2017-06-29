package chapter9;

/**
 * Created by ivan on 29.6.17.
 */
public interface Hello2 {
    default void hello() {
        System.out.println("Hello2.hello call");
    }
}
