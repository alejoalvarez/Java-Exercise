
## Example 1 

Convert a JSON Array to a List of object, using TypeToken

```java
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GsonExample4 {

    public static void main(String[] args) {

        Gson gson = new Gson();
        String json = "[{\"name\":\"alejo\"}, {\"name\":\"alejo2\"}]";
        List<Staff> list = gson.fromJson(json, new TypeToken<List<Staff>>() {}.getType());
        list.forEach(x -> System.out.println(x));
    }
}
```

```java
Output >>>
----------

Staff{name='mkyong', age=0, position=null, skills=null, salary=null}
Staff{name='laplap', age=0, position=null, skills=null, salary=null}
```

## Example 2

```java
Convert a JSON to a Map

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class GsonExample5 {

    public static void main(String[] args) {

        Gson gson = new Gson();

        String json = "{\"name\":\"alejo\", \"age\":123}";
        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());
        map.forEach((x, y) -> System.out.println("key : " + x + " , value : " + y));
    }
}
```

```
Output >>>
----------
key : name , value : alejo
key : age , value : 123
```