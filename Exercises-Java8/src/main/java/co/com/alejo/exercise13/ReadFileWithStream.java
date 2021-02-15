package co.com.alejo.exercise13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileWithStream {

    public static void main(String args[]) {

        // This is the path where the file is stored
        String fileName = "/path/lines.txt"; // for mac OS, you need change path for real information
        // String fileName = "c://lines.txt"; // for Windows

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
