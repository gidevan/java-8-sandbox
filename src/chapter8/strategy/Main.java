package chapter8.strategy;

/**
 * Created by ivan on 16.6.17.
 */
public class Main {

    private static final String[] VALUES = {"123", "aaa", "a1", "aAsd1", "aWeff", "ASDWEE"};

    public static void main(String[] args) {
        Validator lowerCaseStringValidator = new Validator((String s) -> s.matches("[a-z]+"));
        Validator numericValidator = new Validator((String s) -> s.matches("\\d+"));
        Validator upperCaseStringValidator = new Validator((String s) -> s.matches("[A-Z]+"));

        for(String val : VALUES) {
            System.out.println();
            System.out.println("value: " + val);
            System.out.println("lowerCaseStringValidator:" + lowerCaseStringValidator.validate(val));
            System.out.println("numericValidator:" + numericValidator.validate(val));
            System.out.println("upperCaseStringValidator:" + upperCaseStringValidator.validate(val));
        }

    }
}
