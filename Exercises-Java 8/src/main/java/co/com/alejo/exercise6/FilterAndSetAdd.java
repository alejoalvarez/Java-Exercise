package co.com.alejo.exercise6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterAndSetAdd {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        Set<Integer> result = findDuplicateBySetAdd(list);
        result.forEach(System.out::println);
    }

    private static  <T> Set<T> findDuplicateBySetAdd(List<T> list) {
        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n))  // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());
    }
}
