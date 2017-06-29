package chapter9;

/**
 * Created by ivan on 29.6.17.
 */
public interface InterfaceB {

    default void method2() {
        System.out.println("InterfaceB.method2 default call");
    }
}
