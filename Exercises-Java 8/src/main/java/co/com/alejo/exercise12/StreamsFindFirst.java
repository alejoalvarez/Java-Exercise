package co.com.alejo.exercise12;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsFindFirst {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 2, 1);

        Optional<Integer> first = list.stream().findFirst();
        if (first.isPresent()) {
            Integer result = first.get();
            System.out.println("The first value is: " + result);       // 1
        } else {
            System.out.println("no exist values"); // when the List is empty
        }

        // Find first element form a Stream of String which is not equal to "node"
        List<String> languages = Arrays.asList("node", "java", "python", "ruby");

        Optional<String> result = languages.stream()
                .filter(x -> !x.equalsIgnoreCase("node"))
                .findFirst();

        if (result.isPresent()) {
            System.out.println("The first string is: " + result.get()); // java
        } else {
            System.out.println("no exist values"); // when the List is empty
        }
    }
}
