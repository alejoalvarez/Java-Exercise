# Exercise 1 - Convert Java Object to/ from JSON

Convert a Staff object to from JSON.

**writeValue(...)** – Java Objects to JSON

```java
ObjectMapper mapper = new ObjectMapper();

// Java object to JSON file
mapper.writeValue(new File("c:\\test\\staff.json"), new Staff());

// Java object to JSON string
String jsonString = mapper.writeValueAsString(object);
```

**readValue(...)** – JSON to Java Objects

```java
ObjectMapper mapper = new ObjectMapper();

//JSON file to Java object
Staff obj = mapper.readValue(new File("c:\\test\\staff.json"), Staff.class);

//JSON URL to Java object
Staff obj = mapper.readValue(new URL("http://some-domains/api/name.json"), Staff.class);

//JSON string to Java Object
Staff obj = mapper.readValue("{'name' : 'mkyong'}", Staff.class);
```

## Example Java Object to JSON
```java
public class Staff {

    private String name;
    private int age;
    private String[] position;              //  Array
    private List<String> skills;            //  List
    private Map<String, BigDecimal> salary; //  Map

    // getters , setters, some boring stuff
}
```

```java
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JavaObjectToJson {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Staff staff = createStaff();

        try {

            // Java objects to JSON file
            mapper.writeValue(new File("c:\\test\\staff.json"), staff);

            // Java objects to JSON string - compact-print
            String jsonString = mapper.writeValueAsString(staff);

            System.out.println(jsonString);

            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);

            System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Staff createStaff() {

        Staff staff = new Staff();

        staff.setName("alejo");
        staff.setAge(123);
        staff.setPosition(new String[]{"Developer", "CTO"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2013", new BigDecimal(130000));
            put("2016", new BigDecimal(160000));
            put("2021", new BigDecimal(210000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node"));

        return staff;
    }
}
```

```
Output >>>

{"name":"alejo","age":123,"position":["Developer","CTO"],"skills":["java","python","node"],"salary":{"2021":210000,"2016":160000,"2013":130000}}

{
  "name" : "alejo",
  "age" : 123,
  "position" : [ "Founder", "CTO" ],
  "skills" : [ "java", "python", "node" ],
  "salary" : {
    "2021" : 210000,
    "2016" : 160000,
    "2013" : 130000
  }
}
```

## Example JSON to Java Objects

```java
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToJavaObject {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            // JSON file to Java object
            Staff staff = mapper.readValue(new File("c:\\test\\staff.json"), Staff.class);

            // JSON string to Java object
            String jsonInString = "{\"name\":\"alejo\",\"age\":123,\"skills\":[\"java\",\"python\"]}";
            Staff staff2 = mapper.readValue(jsonInString, Staff.class);

            // compact print
            System.out.println(staff2);

            // pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);

            System.out.println(prettyStaff1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

```
Staff{name='alejo', age=123, position=null, skills=[java, python], salary=null}

{
  "name" : "alejo",
  "age" : 123,
  "position" : null,
  "skills" : [ "java", "python" ],
  "salary" : null
}
```



