package chapter8.factory.classic;

/**
 * Created by ivan on 27.6.17.
 */
public class Stock implements Product {
    private String name;

    public Stock() {
        this.name = "stock";
    }

    @Override
    public String getName() {
        return name;
    }

}
