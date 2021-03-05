package co.com.alejo.exercise5;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveType {

    public static void main(String[] args) {

        // Example 1 flatMapToInt -> IntStream
        int[] array = {1, 2, 3, 4, 5, 6};

        Stream<int[]> streamArray = Stream.of(array); //Stream<int[]>
        IntStream intStream = streamArray.flatMapToInt(Arrays::stream); //Stream<int[]> -> flatMap -> IntStream
        intStream.forEach(System.out::println);

        // Example 2 flatMapToLong -> LongStream
        long[] array2 = {1, 2, 3, 4, 5, 6};

        Stream<long[]> longArray = Stream.of(array2);
        LongStream longStream = longArray.flatMapToLong(Arrays::stream);
        System.out.println(longStream.count()); // Count total record in longArray
    }
}
