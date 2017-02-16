package lamdas;

/**
 * Created by ivan on 16.2.17.
 */
public class Apple {
    private String country;
    private String color;
    private double weight;

    public Apple() {
    }

    public Apple(String country, String color, double weight) {
        this.country = country;
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
