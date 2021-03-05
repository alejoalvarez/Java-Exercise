package co.com.alejo.exercise14;

import java.util.Arrays;

public class StreamToArrayString {

    public static void main(String[] args) {

        String lines = "I need to learn java";

        String[] result = Arrays.stream(lines.split("\\s+")) // Split by space
                .map(String::toUpperCase)
                .toArray(String[]::new); // Convert to array

        for (String s : result) {
            System.out.println(s);
        }

    }
}
