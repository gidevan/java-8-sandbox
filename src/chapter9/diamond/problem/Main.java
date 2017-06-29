package chapter9.diamond.problem;

import chapter9.diamond.problem.case1.D;
import chapter9.diamond.problem.case2.Case2Impl;
import chapter9.diamond.problem.case3.Case3Impl;

/**
 * Created by ivan on 29.6.17.
 */
public class Main {

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
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
}
