package chapter9;

/**
 * Created by ivan on 29.6.17.
 */
public class Hello implements Hello1, Hello2 {

    @Override
    public void hello() {
        System.out.println("Hello.hello call");
        Hello1.super.hello();
    }
}
