package chapter10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ivan on 30.6.17.
 */
public class Main {

    private static final String[] CAR_NAMES = {"volvo", "bmv"};
    private static final String CAR_NAME = CAR_NAMES[0];
    private static final String[] INSURANCE_NAMES = {"insuranceName", "newInsuranceName"};
    private static final String INSURANCE_NAME = INSURANCE_NAMES[0];
    private static final String PERSON_NAME = "personName";
    private static final int AGES[] = {23, 44, 45, 22};
    private static final int AGE = 25;
    private static final int AGE_CONDITION = 19;


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        System.out.println();
        System.out.println("test1");
        Insurance insurance = createInsurance("insurance1");
        Car car = createCar(CAR_NAME, Optional.of(insurance));
        Person person = createPerson(PERSON_NAME, Optional.of(car));

        Optional<Person> optPerson = Optional.of(person);

        String insuranceName = optPerson.flatMap(Person :: getCar).flatMap(Car :: getInsurance).map(Insurance :: getName).orElse("Unknown");
        System.out.println("insuranceName: " + insuranceName);
    }

    private static void test2() {
        System.out.println();
        System.out.println("test2");
        Car car = createCar(CAR_NAME, Optional.empty());
        Person person = createPerson(PERSON_NAME, Optional.of(car));

        Optional<Person> optPerson = Optional.of(person);

        String insuranceName = optPerson.flatMap(Person :: getCar).flatMap(Car :: getInsurance).map(Insurance :: getName).orElse("Unknown");
        System.out.println("insuranceName: " + insuranceName);
    }

    private static void test3() {
        System.out.println();
        System.out.println("test3");
        Person person = createPerson(PERSON_NAME, Optional.empty());

        Optional<Person> optPerson = Optional.of(person);

        String insuranceName = optPerson.flatMap(Person :: getCar).flatMap(Car :: getInsurance).map(Insurance :: getName).orElse("Unknown");
        System.out.println("insuranceName: " + insuranceName);
    }

    private static void test4() {
        System.out.println();
        System.out.println("test4");
        Insurance insurance = createInsurance(INSURANCE_NAME);
        Optional<Insurance> optInsurance = Optional.of(insurance);
        optInsurance.filter(x -> INSURANCE_NAME.equals(x.getName())).ifPresent(x -> System.out.println("insurance present: " + INSURANCE_NAME));
        optInsurance.filter(x -> CAR_NAME.equals(x.getName())).ifPresent(x -> System.out.println("insurance present: " + CAR_NAME));
    }

    private static void test5() {
        System.out.println();
        System.out.println("test5");
        List<Person> persons = createPersons();
        System.out.println(persons);
        List<String> names = persons.stream().filter(p -> p.getAge() > AGE_CONDITION).map(p -> Optional.of(p))
                .map(p -> p.flatMap(Person :: getCar).flatMap(Car :: getInsurance).map(Insurance :: getName).orElse("Unknown")).collect(Collectors.toList());
        System.out.println();
        System.out.println(names);
    }

    private static Insurance createInsurance(String name) {
        Insurance insurance = new Insurance();
        insurance.setName(name);
        return insurance;
    }

    private static Car createCar(String name, Optional<Insurance> insurance) {
        Car car = new Car();
        car.setName(name);
        car.setInsurance(insurance);
        return car;
    }

    private static Person createPerson(String name, Optional<Car> car, int age) {
        Person person = new Person();
        person.setName(name);
        person.setCar(car);
        person.setAge(age);
        return person;
    }

    private static Person createPerson(String name, Optional<Car> car) {
        return createPerson(name, car, AGE);
    }



    private static List<Person> createPersons() {
        List<Person> persons = new ArrayList<>();
        for(int age : AGES) {
            Insurance insurance = createInsurance(INSURANCE_NAMES[age % 2] + age);
            Car car = createCar(CAR_NAMES[age % 2] + age, Optional.of(insurance));
            Person person = createPerson(PERSON_NAME + age, Optional.of(car), age);
            persons.add(person);
        }
        return persons;
    }
}
