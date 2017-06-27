package chapter8.factory.functional;

import chapter8.factory.classic.Bond;
import chapter8.factory.classic.Loan;
import chapter8.factory.classic.Product;
import chapter8.factory.classic.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by ivan on 27.6.17.
 */
public class ProductFactory {
    private static final Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if(p != null) {
            return p.get();
        }
        throw new IllegalArgumentException("Wrong product name: " + name);
    }
}
