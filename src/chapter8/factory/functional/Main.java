package chapter8.factory.functional;

import chapter8.factory.classic.Product;

/**
 * Created by ivan on 27.6.17.
 */
public class Main {

    public static void main(String[] args) {
        Product p = ProductFactory.createProduct("stock");
        System.out.println(p.getName());

        Product p1 = ProductFactory.createProduct("bond222");
    }
}
