package lamdas;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class FruitBox {
    private static final String[] COUNTRIES = {"Belarus", "Poland", "Brasil", "Russia"};
    private static final String[] COLORS = {"red", "green", "yellow"};
    private static final double[] WEIGHTS = {110, 50, 65, 123, 60, 90};
    private static final int RANDOM_ITEM_COUNT = 10;
    private List<Apple> apples;

    public FruitBox() {
        this.apples = new ArrayList<>();
        apples.add(new Apple(COUNTRIES[0], COLORS[0], WEIGHTS[0]));
        apples.add(new Apple(COUNTRIES[1], COLORS[1], WEIGHTS[0]));
        apples.add(new Apple(COUNTRIES[2], COLORS[2], WEIGHTS[0]));
        apples.add(new Apple(COUNTRIES[3], COLORS[2], WEIGHTS[0]));
        for(int i = 0; i < RANDOM_ITEM_COUNT; i++) {
            int countryIndex = new Random().nextInt(COUNTRIES.length - 1);
            int colorIndex = new Random().nextInt(COLORS.length - 1);
            int weightIndex = new Random().nextInt(WEIGHTS.length - 1);
            apples.add(new Apple(COUNTRIES[countryIndex], COLORS[colorIndex], WEIGHTS[weightIndex]));
        }
    }


    /**
     * Returns Belarus apples
     * @return
     */
    public List<Apple> getBelarusApples() {
        return apples.stream().filter(apple -> COUNTRIES[0].equals(apple.getCountry()))
                .collect(Collectors.toList());
    }

    /**
     * Returns Belarus apples sort by weight asc
     * @return
     */
    public List<Apple> getBelarusApplesSortByWeightsAsc() {
        List<Apple> result = apples.stream().filter(apple -> COUNTRIES[0].equals(apple.getCountry()))
                .collect(Collectors.toList());
        result.sort(comparing(Apple::getWeight));
        return result;
    }

    /**
     * Returns Belarus apples sort by weight desc
     * @return
     */
    public List<Apple> getBelarusApplesSortByWeightsDesc() {
        List<Apple> result = apples.stream().filter(apple -> COUNTRIES[0].equals(apple.getCountry()))
                .collect(Collectors.toList());
        result.sort(comparing(Apple::getWeight).reversed());
        return result;
    }

    /**
     * Returns Belarus and Brasil apples
     * @return
     */
    public List<Apple> getBelarusAndBrasilApples() {
        Predicate<Apple> belarusPredicate = apple -> COUNTRIES[0].equals(apple.getCountry());
        Predicate<Apple> brasilPredicate = apple -> COUNTRIES[2].equals(apple.getCountry());
        return apples.stream().filter(belarusPredicate.or(brasilPredicate))
                .collect(Collectors.toList());
    }

    /**
     * Returns Belarus and Brasil apples. Sorted by country and weight
     * @return
     */
    public List<Apple> getBelarusAndBrasilApplesSortByCountryAndWeight() {
        Predicate<Apple> belarusPredicate = apple -> COUNTRIES[0].equals(apple.getCountry());
        Predicate<Apple> brasilPredicate = apple -> COUNTRIES[2].equals(apple.getCountry());
        List<Apple> result = apples.stream().filter(belarusPredicate.or(brasilPredicate))
                .collect(Collectors.toList());
        result.sort(comparing(Apple::getCountry).thenComparing(Apple::getWeight));
        return result;
    }

    /**
     * Returns red Belarus and green Poland apples
     * @return
     */
    public List<Apple> getRedBelarusAndGreenPoland() {
        Predicate<Apple> belarusPredicate = (apple -> COUNTRIES[0].equals(apple.getCountry()) && COLORS[0].equals(apple.getColor()));
        Predicate<Apple> polandPredicate = (apple -> COUNTRIES[1].equals(apple.getCountry()) && COLORS[1].equals(apple.getColor()));
        return apples.stream().filter(belarusPredicate.or(polandPredicate)).collect(Collectors.toList());
    }

    /**
     * Returns yellow Russia and green or red Belarus apples
     * @return
     */
    public List<Apple> getYellowRussiaAndGreenOrRedBelarus() {
        Predicate<Apple> belarusPredicate = (apple -> COUNTRIES[0].equals(apple.getCountry())
                && (COLORS[0].equals(apple.getColor()) || COLORS[1].equals(apple.getColor())));
        Predicate<Apple> russiaPredicate = (apple -> COUNTRIES[3].equals(apple.getCountry()) && COLORS[2].equals(apple.getColor()));
        return apples.stream().filter(belarusPredicate.or(russiaPredicate)).collect(Collectors.toList());
    }

    /**
     * Returns Poland not green and Russia not yelow apples
     * @return
     */
    public List<Apple> getPolandNotGreenAndRussiaYellowApples() {
        Predicate<Apple> polandPredicate = (apple -> COUNTRIES[1].equals(apple.getCountry())
                && (!COLORS[1].equals(apple.getColor())));
        Predicate<Apple> russiaPredicate = (apple -> COUNTRIES[3].equals(apple.getCountry()) && COLORS[2].equals(apple.getColor()));
        return apples.stream().filter(polandPredicate.or(russiaPredicate)).collect(Collectors.toList());
    }

}
