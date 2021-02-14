package co.com.alejo.exercise5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAllBook {

    public static void main(String[] args) {
        Developer dev1 = new Developer();
        dev1.setName("Alejo");
        dev1.addBook("Java Example");
        dev1.addBook("Tutorials Java");
        dev1.addBook("Java 8");
        dev1.addBook("Python Advance");

        Developer dev2 = new Developer();
        dev2.setName("Alejo 2");
        dev2.addBook("Java Example 2");
        dev2.addBook("Tutorials Python 2");

        List<Developer> list = new ArrayList<>();
        list.add(dev1);
        list.add(dev2);

        Set<String> collect = list.stream()
                .map(Developer::getBook) // Stream<Set<String>>
                .flatMap(Collection::stream) // Stream<String>
                .filter(x -> !x.toLowerCase().contains("python")) // filter python book
                .collect(Collectors.toSet()); // Remove duplicated

        collect.forEach(System.out::println);
    }
}
