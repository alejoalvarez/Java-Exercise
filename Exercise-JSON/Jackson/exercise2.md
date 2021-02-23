# Convert JSON array String to List
```java
String json = "[{\"name\":\"alejo\", \"age\":123}, {\"name\":\"alejo2\", \"age\":123}]";

List<Staff> list = Arrays.asList(mapper.readValue(json, Staff[].class));

// or like this:
// List<Staff> list = mapper.readValue(json, new TypeReference<List<Staff>>(){});
```

# Convert JSON string to Map
```java

String json = "{\"name\":\"alejo\", \"age\":\"123\"}";
            
Map<String, String> map = mapper.readValue(json, Map.class);

// or like this:
//Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});

map.forEach((k, v) -> System.out.format("[key]:%s \t[value]:%s\n", k, v));

```