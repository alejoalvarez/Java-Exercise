package co.com.alejo.exercise23;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression3 {

    public static void main(String[] args) {

        List<String> numbers = Arrays.asList("8", "15", "A15", "333", "B2A");

        Pattern pattern = Pattern.compile("\\d+");

        numbers.stream()
                .map(pattern::matcher)
                .filter(Matcher::find)          // A2A211, will it loop?
                .map(Matcher::group)
                .forEach(System.out::println);
    }
}
