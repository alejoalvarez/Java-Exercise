package co.com.alejo.exercise9;

import java.util.stream.IntStream;

public class IsStreamParallelMode {

    public static void main(String[] args) {

        System.out.println("Normal...");

        IntStream range = IntStream.rangeClosed(1, 10);
        System.out.println(range.isParallel());         // false
        range.forEach(System.out::println);

        // Show the current thread that perform the operation
        /*range.forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });*/

        System.out.println("Normal..."); // Separate the output examples

        System.out.println("Parallel...");

        IntStream range2 = IntStream.rangeClosed(1, 10);
        IntStream range2Parallel = range2.parallel();
        System.out.println(range2Parallel.isParallel()); // true
        range2Parallel.forEach(System.out::println);

        // Show the current thread that perform the operation
        /*range2.parallel().forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });*/


    }
}
