package chapter9.diamond.problem.case3;

/**
 * Created by ivan on 29.6.17.
 */
public class Case3Impl implements Case3A, Case3B {
    @Override
    public void hello() {
        System.out.println("Case3Impl.hello call");
    }
}
