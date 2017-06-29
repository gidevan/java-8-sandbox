package chapter9;

/**
 * Created by ivan on 29.6.17.
 */
public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        System.out.println();
        System.out.println("test1");
        ClassB b = new ClassB();
        b.method1();
        b.method2();
    }

    private static void test2() {
        System.out.println();
        System.out.println("test2");
        ClassC c = new ClassC();
        c.method3();

    }

    private static void test3() {
        System.out.println();
        System.out.println("test3");
        Hello hello = new Hello();
        hello.hello();
    }
}
