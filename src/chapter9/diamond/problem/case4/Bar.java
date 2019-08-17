package chapter9.diamond.problem.case4;

/**
 * Created by vano on 18.8.19.
 */
public interface Bar {
    default void bar1() {
        System.out.println("Bar.bar1");
    }

    default void bar2() {
        System.out.println("Bar.bar2");
    }
}
