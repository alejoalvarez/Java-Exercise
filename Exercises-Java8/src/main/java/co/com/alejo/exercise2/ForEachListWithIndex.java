package co.com.alejo.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForEachListWithIndex {

    public static void main(String[] args) {

        // Example wit an Array
        String[] names = {"Java", "NodeJS", "JavaScript", "Python", "Go"};

        List<String> languages = IntStream.range(0, names.length)
                .mapToObj(index -> index + ":" + names[index])
                .collect(Collectors.toList());

        languages.forEach(System.out::println);
        
        //Example with a List
        List<String> languages2 = Arrays.asList("Java", "NodeJS", "JavaScript", "Python", "Go");
        HashMap<Integer, String> collect = languages2
                .stream()
                .collect(HashMap<Integer, String>::new,
                        (map, streamValue) -> map.put(map.size(), streamValue),
                        (map, map2) -> {
                        });

        collect.forEach((k, v) -> System.out.println(k + ":" + v));


    }

}
