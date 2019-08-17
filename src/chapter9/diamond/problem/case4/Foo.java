package chapter9.diamond.problem.case4;

/**
 * Created by vano on 18.8.19.
 */
public interface Foo {

    default void bar1() {
        System.out.println("Foo.bar1");
    }
}
