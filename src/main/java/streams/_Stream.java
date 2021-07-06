package streams;

import imperative.Main;

import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Levi", MALE),
                new Person("Peli", FEMALE),
                new Person("Cecile", FEMALE),
                new Person("Alex", MALE),
                new Person("Erick", MALE)
        );

        people.stream()
                .map(person -> person.gender) // get only gender and removing duplicates
                .collect(Collectors.toSet())  // Transforming to a set
                .forEach(System.out::println);// and display all of theme without duplications.

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
