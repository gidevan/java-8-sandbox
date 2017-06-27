package chapter8.factory.classic;

/**
 * Created by ivan on 27.6.17.
 */
public class Main {

    public static void main(String[] args) {
        Product product = ProductFactory.createProduct("loan");
        System.out.println(product.getName());
        Product p2 = ProductFactory.createProduct("bond");
        System.out.println(p2.getName());
        Product p3 = ProductFactory.createProduct("bond11");
    }
}
