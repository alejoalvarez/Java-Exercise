package co.com.alejo.exercise3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterToMap2 {

    public static void main(String[] args) {

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Youtube");
        map1.put(2, "Spotify");
        map1.put(3, "AWS prime");
        map1.put(4, "Google");

        Map<Integer, String> map2 = map1.entrySet().stream()
                .filter(map -> map.getKey() == 1)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        System.out.println("The result is: " + map2);
    }
}
