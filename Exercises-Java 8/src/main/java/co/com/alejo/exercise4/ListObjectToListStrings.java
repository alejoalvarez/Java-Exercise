package co.com.alejo.exercise4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListObjectToListStrings {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                 new Person("Alejo", 25),
                 new Person("Ana", 26),
                 new Person("Juan", 27)
        );

        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("The conversion is: "+ names);

    }

    static class Person {
        public String getName() {
            return name;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;

    }
}
