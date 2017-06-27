package chapter8.chain.of.responsibility.classic;

/**
 * Created by ivan on 27.6.17.
 */
public class Main {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderSpellProcessing();
        ProcessingObject<String> p2 = new SpellCheckingProcessor();
        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labda`s really sexy?");
        System.out.println(result);
    }
}
