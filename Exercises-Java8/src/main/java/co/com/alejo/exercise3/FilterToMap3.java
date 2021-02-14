package co.com.alejo.exercise3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterToMap3 {

    public static void main(String[] args) {

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Youtube");
        map1.put(2, "Spotify");
        map1.put(3, "AWS prime");
        map1.put(4, "Google");

        Map<Integer, String> filterMap1 = filterByValue(map1, x -> x.contains("AWS prime"));
        System.out.println("The result for filter 1 is:  " + filterMap1);

        Map<Integer, String> filterMap2 = filterByValue(map1,x -> (x.contains("Youtube") || x.contains("Spotify")));
        System.out.println("The result for filter 2 is: " + filterMap2);

        Map<Integer, String> filterMap3 = filterByValue(map1, x -> (x.length() < 7));
        System.out.println("The result for filter 3 is: " + filterMap3);


    }

    // Create a generic method filtering by value with a Predicate
    public static <K,V> Map<K,V> filterByValue(Map<K,V> map, Predicate<V> predicate){
        return map.entrySet()
                .stream()
                .filter(x -> predicate.test(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
