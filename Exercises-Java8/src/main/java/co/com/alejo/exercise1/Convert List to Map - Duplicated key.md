
# Convert List to Map
---

This is an example that show how to handle the duplicated keys.

Run below code, and duplicated key errors will be thrown!

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMapDuplicatedList {

    public static void main(String[] args) {

        List<PageWeb> list = new ArrayList<>();
        list.add(new PageWeb(1, "aws.com", 80000));
        list.add(new PageWeb(2, "youtube.com", 90000));
        list.add(new PageWeb(3, "netflix.com", 120000));
        list.add(new PageWeb(4, "gmail.com", 200000));
        list.add(new PageWeb(5, "hotmail.com", 1));
        
        list.add(new PageWeb(6, "aws.com", 100000)); // 

        Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(PageWeb::getName, PageWeb::getWebsites));

        System.out.println("Result 1 : " + result1);
    }
}
```

This code show  an error:

```
Exception in thread "main" java.lang.IllegalStateException: Duplicate key 90000
    at java.util.stream.Collectors.lambda$throwingMerger$0(Collectors.java:133)
    at java.util.HashMap.merge(HashMap.java:1245)
    //...
```
To solve the duplicated key issue above, pass a third element like this:

```java
Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites,
                        (oldValue, newValue) -> oldValue
                )
        );
```

``` 
Output >>>

Result 2 : {aws.com=80000, youtube.com=1, netflix.com=120000, gmail=200000, hotmail.com=90000}

```

If you prefer newKey :

```java
 Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites,
                        (oldValue, newValue) -> newvalue
                )
        );
```

``` 
Output >>>

Result 2 : {aws.com=100000, youtube.com=1, netflix.com=120000, gmail=200000, hotmail.com=90000}

```




