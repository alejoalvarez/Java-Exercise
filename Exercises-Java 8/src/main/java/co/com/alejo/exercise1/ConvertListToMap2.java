package co.com.alejo.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap2 {

    public static void main(String[] args) {

        List<PageWeb> list = new ArrayList<>();
        list.add(new PageWeb(1, "aws.com", 80000));
        list.add(new PageWeb(2, "youtube.com", 90000));
        list.add(new PageWeb(3, "netflix.com", 120000));
        list.add(new PageWeb(4, "gmail.com", 200000));
        list.add(new PageWeb(5, "hotmail.com", 1));

        list.add(new PageWeb(6, "aws.com", 100000)); //

        // Print result1 with the old value for aws
        Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(PageWeb::getName, PageWeb::getWebsites,
                        (oldValue, newValue) -> oldValue
                )
        );

        // Print result2 with the newValue for aws
        Map<String, Long> result2 = list.stream().collect(
                Collectors.toMap(PageWeb::getName, PageWeb::getWebsites,
                        (oldValue, newValue) -> newValue
                )
        );

        System.out.println("Result 1 : " + result1);
        System.out.println("Result 2 : " + result2);
    }
}