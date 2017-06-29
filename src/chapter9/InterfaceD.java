package chapter9;

/**
 * Created by ivan on 29.6.17.
 */
public interface InterfaceD extends InterfaceC {
    default void method3() {
        System.out.println("InterfaceD.method3 call");
    }
}
