package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Levi", MALE),
            new Person("Peli", FEMALE),
            new Person("Cecile", FEMALE),
            new Person("Alex", MALE),
            new Person("Erick", MALE)
        );

        System.out.println(" --- Imperative Approach --- ");
        List<Person> females = new ArrayList<>();

        for(Person person: people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for(Person female: females){
            System.out.println(female);
        }

        System.out.println(" --- Declarative Approach --- ");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);
        // or
//        List<Person> females2 = people.stream()
//                .filter(person -> FEMALE.equals(person.gender))
//                .collect(Collectors.toList());
//        females2.forEach(System.out::println);

    }

    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person { " +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE;
    }
}
