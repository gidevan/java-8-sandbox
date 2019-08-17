package chapter9.diamond.problem;

import chapter9.diamond.problem.case1.D;
import chapter9.diamond.problem.case2.Case2Impl;
import chapter9.diamond.problem.case3.Case3Impl;
import chapter9.diamond.problem.case4.Bar;
import chapter9.diamond.problem.case4.Foo;
import chapter9.diamond.problem.case4.FooBarImpl;

/**
 * Created by ivan on 29.6.17.
 */
public class Main {

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
    }

    private static void testCase1() {
        System.out.println();
        System.out.println("Diamond problem case1");
        D d = new D();
        d.hello();
    }

    private static void testCase2() {
        System.out.println();
        System.out.println("Diamond problem case2");
        Case2Impl a = new Case2Impl();
        a.hello();
    }

    private static void testCase3() {
        System.out.println();
        System.out.println("Diamond problem case3");
        Case3Impl a = new Case3Impl();
        a.hello();
    }

    private static void testCase4() {
        System.out.println();
        System.out.println("Diamond problem case4");
        Bar bar = new FooBarImpl();
        Foo foo = new FooBarImpl();

        bar.bar1();
        foo.bar1();

    }
}
