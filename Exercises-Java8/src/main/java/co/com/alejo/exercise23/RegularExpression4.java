package co.com.alejo.exercise23;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegularExpression4 {

    public static void main(String[] args) {

        List<String> numbers = Arrays.asList("1", "20", "A1", "333", "A2A211");

        Pattern pattern = Pattern.compile("\\d+");

        List<String> collect = numbers.stream()
                .map(x -> new Scanner(x).findAll(pattern)
                        .map(m -> m.group())
                        .collect(Collectors.toList())
                )
                .flatMap(List::stream)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

    }
}
