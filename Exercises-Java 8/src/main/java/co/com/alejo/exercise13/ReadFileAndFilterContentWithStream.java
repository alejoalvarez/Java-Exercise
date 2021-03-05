package co.com.alejo.exercise13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileAndFilterContentWithStream {

        public static void main(String args[]) {
            // This is the path where the file is stored
            String fileName = "/path/lines.txt"; // for mac OS, you need change "path" for real information
            // String fileName = "c://lines.txt"; // for Windows
            List<String> list = new ArrayList<>();

            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                list = stream
                        .filter(line -> !line.startsWith("test4")) // filter line that start with "test4"
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.forEach(System.out::println);
        }
}
