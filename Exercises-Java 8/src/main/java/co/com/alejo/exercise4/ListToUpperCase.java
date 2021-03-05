package co.com.alejo.exercise4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListToUpperCase {

    public static void main(String[] args) {

        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

        List<String> upperCase = vowels.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("The original list is:" + vowels);
        System.out.println("The upper Case list is: " + upperCase);

    }
}
