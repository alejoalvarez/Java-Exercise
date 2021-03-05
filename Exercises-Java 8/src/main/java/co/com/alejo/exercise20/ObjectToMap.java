package co.com.alejo.exercise20;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Map;


public class ObjectToMap {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student();
        student.setName("Alejo");
        student.setAge(28);
        student.setSkills(Arrays.asList("java","python","node"));

        Map<String, ObjectToMap> map = objectMapper.convertValue(student, Map.class);
        System.out.println(map);

    }
}
