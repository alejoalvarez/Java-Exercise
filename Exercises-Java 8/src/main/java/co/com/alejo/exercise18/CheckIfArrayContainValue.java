package co.com.alejo.exercise18;

import java.util.Arrays;

public class CheckIfArrayContainValue {

    public static void main(String[] args) {

        String[] vowels = new String[]{"A", "E", "I", "O", "U"};

        // Convert to stream and test it
        boolean result = Arrays.stream(vowels).anyMatch("A"::equals);
        if (result) {
            System.out.println("The vowel A exist in array");
        }else{
            System.out.println("The vowel doesn`t exist in array");
        }

    }
}
