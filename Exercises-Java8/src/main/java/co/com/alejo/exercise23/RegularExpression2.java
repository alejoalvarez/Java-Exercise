package co.com.alejo.exercise23;

import java.util.Arrays;
import java.util.List;

public class RegularExpression2 {

    public static void main(String[] args) {

        List<String> numbers = Arrays.asList("8", "15", "A15", "333", "B2A");

        // stream example
        numbers.stream()
                .map(x -> x.replaceAll("\\d", "#"))
                .forEach(System.out::println);

    }
}
