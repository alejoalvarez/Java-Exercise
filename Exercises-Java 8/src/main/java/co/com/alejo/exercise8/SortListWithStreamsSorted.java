package co.com.alejo.exercise8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortListWithStreamsSorted {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
        List<String> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);

        //Another way
        List<String> sortedList2 = list.stream()
                .sorted((v1, v2) -> v1.compareTo(v2))
                .collect(Collectors.toList());
        sortedList2.forEach(System.out::println);
    }
}
