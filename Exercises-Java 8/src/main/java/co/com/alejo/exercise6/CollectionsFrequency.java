package co.com.alejo.exercise6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsFrequency {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        Set<Integer> result = findDuplicateByFrequency(list);
        result.forEach(System.out::println);
    }

    public static <T> Set<T> findDuplicateByFrequency(List<T> list) {
        return list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());

    }
}
