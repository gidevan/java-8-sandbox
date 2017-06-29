package chapter9;

/**
 * Created by ivan on 29.6.17.
 */
public interface InterfaceC {

    default void method3() {
        System.out.println("InterfaceC.method3 call");
    }
}
