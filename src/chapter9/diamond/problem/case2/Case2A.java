package chapter9.diamond.problem.case2;

import chapter9.diamond.problem.A;

/**
 * Created by ivan on 29.6.17.
 */
public interface Case2A extends A {
    default void hello() {
        System.out.println("Interface Case2A.hello call");
    }
}
