package chapter9;

/**
 * Created by ivan on 29.6.17.
 */
public interface InterfaceA {
    default void method1() {
        System.out.println("InterfaceA.method1 default call");
    }
}
