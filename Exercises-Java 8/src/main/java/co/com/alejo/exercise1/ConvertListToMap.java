package co.com.alejo.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {

    public static void main(String[] args) {

        List<PageWeb> list = new ArrayList<>();
        list.add(new PageWeb(1, "aws.com", 80000));
        list.add(new PageWeb(2, "youtube.com", 90000));
        list.add(new PageWeb(3, "netflix.com", 120000));
        list.add(new PageWeb(4, "gmail.com", 200000));
        list.add(new PageWeb(5, "hotmail.com", 1));

        Map<Integer, String> result1 = list.stream().collect(
                Collectors.toMap(PageWeb::getId, PageWeb::getName));

        System.out.println("Result 1 : " + result1);

        Map<String, Long> result2 = list.stream().collect(
                Collectors.toMap(PageWeb::getName, PageWeb::getWebsites));

        System.out.println("Result 2 : " + result2);
    }
}