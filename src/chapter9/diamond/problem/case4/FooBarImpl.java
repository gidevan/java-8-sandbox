package chapter9.diamond.problem.case4;

/**
 * Created by vano on 18.8.19.
 */
public class FooBarImpl implements Foo, Bar{

    @Override
    public void bar1() {
        System.out.println("FooBar.bar1");
    }
}
