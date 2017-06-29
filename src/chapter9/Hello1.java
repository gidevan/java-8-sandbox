package chapter9;

/**
 * Created by ivan on 29.6.17.
 */
public interface Hello1 {

    default void hello() {
        System.out.println("Hello1.hello call");
    }
}
