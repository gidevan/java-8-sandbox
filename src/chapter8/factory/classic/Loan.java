package chapter8.factory.classic;

/**
 * Created by ivan on 27.6.17.
 */
public class Loan implements Product {

    private String name;

    public Loan() {
        this.name = "loan";
    }

    @Override
    public String getName() {
        return name;
    }
}
