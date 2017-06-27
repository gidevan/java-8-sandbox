package chapter8.factory.classic;

/**
 * Created by ivan on 27.6.17.
 */
public class Bond implements Product {
    private String name;

    public Bond() {
        this.name = "bond";
    }

    @Override
    public String getName() {
        return name;
    }
}
