package co.com.alejo.exercise18;

import java.util.stream.IntStream;

public class CheckValueInPrimitiveArray {

    public static void main(String[] args) {

        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Java 8
        boolean result = IntStream.of(number).anyMatch(x -> x == 4);

        if (result) {
            System.out.println("The number exist in array");
        } else {
            System.out.println("The number doesn't exist in array");
        }
    }
}
