package co.com.alejo.exercise15;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReuseStream {

    public static void main(String[] args) {

        String[] array = {"a", "b", "c", "d", "e"};
        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);
        streamSupplier.get().forEach(System.out::println); //get new stream

        long count = streamSupplier.get().filter(x -> "b".equals(x)).count(); //get another new stream
        System.out.println("The quantity is: " + count);
    }
}
