package co.com.alejo.exercise3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterToMap {

    public static void main(String[] args) {

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Youtube");
        map1.put(2, "Spotify");
        map1.put(3, "AWS prime");
        map1.put(4, "Google");

        String result = "";
        for(Map.Entry<Integer, String> entry : map1.entrySet()){
            if ("Spotify".equals(entry.getValue())){
                result = entry.getValue();
            }
        }
        System.out.println("The result 1 is: " + result); // The result 1 is Spotify

        // Using Java 8
        result = map1.entrySet().stream()
                .filter(map -> "Youtube".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());

        System.out.println("The result 2 is: " + result); // The result 2 is: Youtube

        // Filtering more values
        result = map1.entrySet().stream()
                .filter(map -> {
                    if(!map.getValue().contains("Youtube") && !map.getValue().contains("Google") ){
                        return true;
                    }
                    return false;
                })
                .map(map -> map.getValue())
                .collect(Collectors.joining(","));

        System.out.println("The result 3 is: "+ result); // The result is: Spotify,AWS prime
    }
}
