package chapter9.diamond.problem;

/**
 * Created by ivan on 29.6.17.
 */
public interface A {
    default void hello() {
        System.out.println("Interface A.hello call");
    }
}
