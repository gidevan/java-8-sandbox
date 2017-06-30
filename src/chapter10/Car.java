package chapter10;

import java.util.Optional;

/**
 * Created by ivan on 30.6.17.
 */
public class Car {
    private String name;
    private Optional<Insurance> insurance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", insurance=" + insurance +
                '}';
    }
}
