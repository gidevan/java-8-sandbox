package lamdas;

import java.util.List;

/**
 * Created by ivan on 16.2.17.
 */
public class Main {
    public static void main(String[] args) {
        FruitBox fruitBox = new FruitBox();
        getBelarusApples(fruitBox);
        getBelarusSortByWeightAsc(fruitBox);
        getBelarusSortByWeightDesc(fruitBox);
        getBelarusAndBrasilApples(fruitBox);
        getBelarusAndBrasilApplesSortedByCountryAndWeight(fruitBox);
        getRedBelarusAndGreenPoland(fruitBox);
        getYellowRussiaAndGreenOrRedBelarus(fruitBox);
        getPolandNotGreenAndRussiaYellowApples(fruitBox);
    }

    private static void getBelarusApples(FruitBox fruitBox) {
        List<Apple> belarusApples = fruitBox.getBelarusApples();
        if(belarusApples.isEmpty()) {
            throw new IllegalStateException("Result is wrong");
        }
        for(Apple apple : belarusApples) {
            if(!"Belarus".equals(apple.getCountry())) {
                throw new IllegalStateException("country is: " + apple.getCountry());
            };
        }
    }

    private static void getBelarusSortByWeightAsc(FruitBox fruitBox) {
        List<Apple> apples = fruitBox.getBelarusApplesSortByWeightsAsc();
        if(apples.isEmpty()) {
            throw new IllegalStateException("Result is wrong");
        }
        double weight = - 1;
        for(Apple apple : apples) {
            if(!"Belarus".equals(apple.getCountry())) {
                throw new IllegalStateException("country is: " + apple.getCountry());
            };
            if(weight > apple.getWeight()) {
                throw new IllegalStateException("Wrong sorting: previos weight: " + weight + " current weight: " + apple.getWeight());
            }
            weight = apple.getWeight();
        }
    }

    private static void getBelarusSortByWeightDesc(FruitBox fruitBox) {
        List<Apple> apples = fruitBox.getBelarusApplesSortByWeightsDesc();
        if(apples.isEmpty()) {
            throw new IllegalStateException("Result is wrong");
        }
        double weight = 111111;
        for(Apple apple : apples) {
            if(!"Belarus".equals(apple.getCountry())) {
                throw new IllegalStateException("country is: " + apple.getCountry());
            };
            if(weight < apple.getWeight()) {
                throw new IllegalStateException("Wrong sorting: previos weight: " + weight + " current weight: " + apple.getWeight());
            }
            weight = apple.getWeight();
        }
    }

    private static void getBelarusAndBrasilApples(FruitBox fruitBox) {
        List<Apple> apples = fruitBox.getBelarusAndBrasilApples();
        if(apples.isEmpty()) {
            throw new IllegalStateException("Result is wrong");
        }

        for(Apple apple : apples) {
            if(!("Belarus".equals(apple.getCountry()) || "Brasil".equals(apple.getCountry()))) {
                throw new IllegalStateException("country is: " + apple.getCountry());
            };
        }
    }

    private static void getBelarusAndBrasilApplesSortedByCountryAndWeight(FruitBox fruitBox) {
        List<Apple> apples = fruitBox.getBelarusAndBrasilApplesSortByCountryAndWeight();
        if(apples.isEmpty()) {
            throw new IllegalStateException("Result is wrong");
        }
        String country = "";
        double weight = -111;
        for(Apple apple : apples) {
            if(!("Belarus".equals(apple.getCountry()) || "Brasil".equals(apple.getCountry()))) {
                throw new IllegalStateException("country is: " + apple.getCountry());
            };
            if(!country.equals(apple.getCountry())) {
                weight = -1111;
            }
            if(apple.getCountry().compareTo(country) < 0) {
                throw new IllegalStateException("country: " + country + " apple country: " + apple.getCountry());
            }
            if(apple.getWeight() < weight) {
                throw new IllegalStateException("weight: " + weight + " apple weight: " + apple.getWeight());
            }
            country = apple.getCountry();
            weight = apple.getWeight();
        }
    }

    private static void getRedBelarusAndGreenPoland(FruitBox fruitBox) {
        List<Apple> apples = fruitBox.getRedBelarusAndGreenPoland();
        if(apples.isEmpty()) {
            throw new IllegalStateException("Result is wrong");
        }
        for(Apple apple : apples) {
            if(!("Belarus".equals(apple.getCountry()) || "Poland".equals(apple.getCountry()))) {
                throw new IllegalStateException("country is: " + apple.getCountry());
            };
            if("Belarus".equals(apple.getCountry()) && !"red".equals(apple.getColor())) {
                throw new IllegalStateException("Wrong color:  " + apple.getCountry() + " " + apple.getColor());
            }
            if("Poland".equals(apple.getCountry()) && !"green".equals(apple.getColor())) {
                throw new IllegalStateException("Wrong color:  " + apple.getCountry() + " " + apple.getColor());
            }
        }
    }

    private static void getYellowRussiaAndGreenOrRedBelarus(FruitBox fruitBox) {
        List<Apple> apples = fruitBox.getYellowRussiaAndGreenOrRedBelarus();
        if(apples.isEmpty()) {
            throw new IllegalStateException("Result is wrong");
        }
        for(Apple apple : apples) {
            if(!("Belarus".equals(apple.getCountry()) || "Russia".equals(apple.getCountry()))) {
                throw new IllegalStateException("country is: " + apple.getCountry());
            };
            if("Belarus".equals(apple.getCountry()) && !("red".equals(apple.getColor()) || "green".equals(apple.getColor()))) {
                throw new IllegalStateException("Wrong color:  " + apple.getCountry() + " " + apple.getColor());
            }
            if("Russia".equals(apple.getCountry()) && !"yellow".equals(apple.getColor())) {
                throw new IllegalStateException("Wrong color:  " + apple.getCountry() + " " + apple.getColor());
            }
        }
    }

    private static void getPolandNotGreenAndRussiaYellowApples(FruitBox fruitBox) {
        List<Apple> apples = fruitBox.getPolandNotGreenAndRussiaYellowApples();
        if(apples.isEmpty()) {
            throw new IllegalStateException("Result is wrong");
        }
        for(Apple apple : apples) {
            if(!("Poland".equals(apple.getCountry()) || "Russia".equals(apple.getCountry()))) {
                throw new IllegalStateException("country is: " + apple.getCountry());
            };
            if("Poland".equals(apple.getCountry()) && "green".equals(apple.getColor())) {
                throw new IllegalStateException("Wrong color:  " + apple.getCountry() + " " + apple.getColor());
            }
            if("Russia".equals(apple.getCountry()) && !"yellow".equals(apple.getColor())) {
                throw new IllegalStateException("Wrong color:  " + apple.getCountry() + " " + apple.getColor());
            }
        }
    }
}
