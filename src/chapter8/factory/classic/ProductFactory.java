package chapter8.factory.classic;

/**
 * Created by ivan on 27.6.17.
 */
public class ProductFactory {
    public static Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return  new Stock();
            case "bond":
                return new Bond();
            default:
                throw new IllegalArgumentException("Wrong parameter: " + name);
        }
    }
}
