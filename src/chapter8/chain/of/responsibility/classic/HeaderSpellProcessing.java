package chapter8.chain.of.responsibility.classic;

/**
 * Created by ivan on 27.6.17.
 */
public class HeaderSpellProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: " + input;
    }
}
