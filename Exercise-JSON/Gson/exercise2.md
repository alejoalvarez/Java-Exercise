# Example 1

JSON array of object.

```json
[
  {
    "id": 1, "name": "a"
  },
  {
    "id": 2, "name": "b"
  }
]
```

Gson convert above JSON array into a List<Item>.

```java
public class Item {

    private int id;
    private String name;

}
```

```java
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonArray1 {

    public static void main(String[] args) throws IOException {

        JavaParseJsonArray main = new JavaParseJsonArray();

        Gson gson = new Gson();

        Type listType = new TypeToken<List<Item>>() {}.getType();

        List<Item> list = gson.fromJson(main.loadFileFromClasspath("array1.json"), listType);

        System.out.println(gson.toJson(list));

    }

    public String loadFileFromClasspath(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            // common-io
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }
}
```

# Example 2

JSON array of {object with an array of object}.

```json

[
  {
    "id": 1,
    "name": "a",
    "types":
    [
      {"id": 1,"name": "a1"},
      {"id": 2,"name": "a2"}
    ]
  },
  {
    "id": 2,
    "name": "b",
    "types":
    [
      {"id": 1,"name": "b1"},
      {"id": 2,"name": "b2"}
    ]
  }
]
```

Gson convert above JSON array into a List<Item> containing List<ItemType> types.

```java
import java.util.List;

public class Item {

    private int id;
    private String name;
    private List<ItemType> types;

}
```

```java
public class ItemType {

    private int id;
    private String name;

}
```

Same code, no need to change.

```java
Type listType = new TypeToken<List<Item>>() {}.getType();
List<Item> list = gson.fromJson(main.loadFileFromClasspath("array2.json"), listType);
```

# Example 3

JSON array of {object with an array of an array of object}.

```json
[
  {
    "id": 1,
    "name": "a",
    "types":
    [
      [
        {"id": 1,"name": "a1"},
        {"id": 2,"name": "a2"}
      ],
      [
        {"id": 3,"name": "a3"}
      ]
    ]
  },
  {
    "id": 2,
    "name": "b",
    "types":
    [
      [
        {"id": 1,"name": "b1"}
      ],
      [
        {"id": 2,"name": "b2"}
      ]
    ]
  }
]
```

Change the types to List<ItemType> types[];

```java
import java.util.List;

public class Item {

    private int id;
    private String name;
    private List<ItemType> types[]; // change types -> types[]
}
````

```java
public class ItemType {

    private int id;
    private String name;

}
```

Same code, no need to change.

```java
Type listType = new TypeToken<List<Item>>() {}.getType();
List<Item> list = gson.fromJson(main.loadFileFromClasspath("array3.json"), listType);
```

# Example 4

JSON array of {object with an array of an array of String}

```json
[
  {
    "id": 1,
    "name": "a",
    "types":
    [
      [
        "a1", 1
      ],
      [
        "a2", 2
      ]
    ]
  },
  {
    "id": 2,
    "name": "b",
    "types":
    [
      [
        "b1", 1
      ]
    ]
  }
]
```

Change the types to List<String> types[];

```java
import java.util.List;

public class Item {

    private int id;
    private String name;
    private List<String> types[];

}
```
Same code, no need to change.

```java
Type listType = new TypeToken<List<Item>>() {}.getType();
List<Item> list = gson.fromJson(main.loadFileFromClasspath("array4.json"), listType);
```