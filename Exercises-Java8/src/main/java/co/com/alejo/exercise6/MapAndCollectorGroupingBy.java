package co.com.alejo.exercise6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapAndCollectorGroupingBy {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        Set<Integer> result = findDuplicateByGrouping(list);
        result.forEach(System.out::println);
    }

    public static <T> Set<T> findDuplicateByGrouping(List<T> list){
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())) // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
                .entrySet().stream() // Map -> Stream
                .filter(m -> m.getValue() > 1) // if map value > 1, duplicate element
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
