# Streaming model example

This Jackson tutorial show you how to use **JsonGenerator** to write JSON string and JSON array into a file, furthermore, read it with **JsonParser**

Jackson Streaming APIs

**JsonGenerator** – Write JSON
**JsonParser** – Parse JSON

## JsonGenerator - write JSON

Write JSON to a file.

```java
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonExample1 {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try (JsonGenerator jGenerator =
                     mapper.getFactory().createGenerator(
                             new File("c:\\projects\\user.json")
                             , JsonEncoding.UTF8)) {
            
            jGenerator.writeStartObject();                                  // {
            jGenerator.writeStringField("name", "alejo");  				
            jGenerator.writeNumberField("age", 123);         				
            jGenerator.writeFieldName("messages");                          // "messages" :

            jGenerator.writeStartArray();                                   // [

            jGenerator.writeString("msg 1");                            		// "msg 1"
            jGenerator.writeString("msg 2");                            		// "msg 2"
            jGenerator.writeString("msg 3");                            		// "msg 3"

            jGenerator.writeEndArray();                                     // ]

            jGenerator.writeEndObject();                                    // }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

```
Output >>>
----------
{"name":"mkyong","age":38,"messages":["msg 1","msg 2","msg 3"]}
```

## JsonGenerator – Write JSON Array

Write JSON array to a file.
```java
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonExample2 {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try (JsonGenerator jGenerator =
                     mapper.getFactory().createGenerator(
                             new File("c:\\projects\\user2.json")
                             , JsonEncoding.UTF8)) {

            // pretty print
            jGenerator.useDefaultPrettyPrinter();

            // start array
            jGenerator.writeStartArray();                                   // [

            jGenerator.writeStartObject();                                  // {

            jGenerator.writeStringField("name", "alejo");  				
            jGenerator.writeNumberField("age", 123);         			

            jGenerator.writeFieldName("messages");                          // "messages" :

            jGenerator.writeStartArray();                                   // [

            jGenerator.writeString("msg 1");                            	// "msg 1"
            jGenerator.writeString("msg 2");                            	// "msg 2"
            jGenerator.writeString("msg 3");                            	// "msg 3"

            jGenerator.writeEndArray();                                     // ]

            jGenerator.writeEndObject();                                    // }

            // next object, pls

            jGenerator.writeStartObject();                                  // {

            jGenerator.writeStringField("name", "alejo2");  					
            jGenerator.writeNumberField("age", 123);         					

            jGenerator.writeFieldName("messages");                          // "messages" :

            jGenerator.writeStartArray();                                   // [

            jGenerator.writeString("msg a");                            	// "msg a"
            jGenerator.writeString("msg b");                            	// "msg b"
            jGenerator.writeString("msg c");                            	// "msg c"

            jGenerator.writeEndArray();                                     // ]

            jGenerator.writeEndObject();                                    // }

            jGenerator.writeEndArray();                                     // ]

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

```
Output >>>
----------
[ 
    {
      "name" : "alejo",
      "age" : 123,
      "messages" : [ "msg 1", "msg 2", "msg 3" ]
    }, {
      "name" : "alejo2",
      "age" : 123,
      "messages" : [ "msg a", "msg b", "msg c" ]
    } 
]
```

## JsonParser – Read JSON

In Jackson streaming mode, it splits JSON string into a list of tokens, and each token will be processed incremental. For example,

```
{
   "name":"alejo"
}
```
* Token 1 = {
* Token 2 = name
* Token 3 = alejo
* Token 4 = }

JsonParser example to parse a JSON file.

```json
{"name":"alejo","age":123,"messages":["msg 1","msg 2","msg 3"]}
```

```java
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.File;
import java.io.IOException;

public class JacksonExample3 {

    public static void main(String[] args) {

        try (JsonParser jParser = new JsonFactory()
                .createParser(new File("c:\\projects\\user.json"));) {

            // loop until token equal to "}"
            while (jParser.nextToken() != JsonToken.END_OBJECT) {

                String fieldname = jParser.getCurrentName();
                
                if ("name".equals(fieldname)) {
                    // current token is "name",
                    // move to next, which is "name"'s value
                    jParser.nextToken();
                    System.out.println(jParser.getText());
                }

                if ("age".equals(fieldname)) {
                    jParser.nextToken();
                    System.out.println(jParser.getIntValue());
                }

                if ("messages".equals(fieldname)) {

                    if (jParser.nextToken() == JsonToken.START_ARRAY) {
                        // messages is array, loop until token equal to "]"
                        while (jParser.nextToken() != JsonToken.END_ARRAY) {
                            System.out.println(jParser.getText());
                        }
                    }

                }

            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

```
Output >>>
----------

alejo
123
msg 1
msg 2
msg 3
```

## JsonParser – Read JSON Array

 JsonParser example to parse a JSON array file.

 ```json
 [ 
    {
      "name" : "alejo",
      "age" : 123,
      "messages" : [ "msg 1", "msg 2", "msg 3" ]
    }, {
      "name" : "alejo2",
      "age" : 123,
      "messages" : [ "msg a", "msg b", "msg c" ]
    } 
]
```

```java
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.File;
import java.io.IOException;

public class JacksonExample4 {

    public static void main(String[] args) {

        try (JsonParser jParser = new JsonFactory()
                .createParser(new File("c:\\projects\\user2.json"));) {

            // JSON array?
            if (jParser.nextToken() == JsonToken.START_ARRAY) {

                while (jParser.nextToken() != JsonToken.END_ARRAY) {

                    // loop until token equal to "}"
                    while (jParser.nextToken() != JsonToken.END_OBJECT) {

                        String fieldname = jParser.getCurrentName();
                        if ("name".equals(fieldname)) {
                            // current token is "name",
                            // move to next, which is "name"'s value
                            jParser.nextToken();
                            System.out.println(jParser.getText());
                        }

                        if ("age".equals(fieldname)) {
                            jParser.nextToken();
                            System.out.println(jParser.getIntValue());
                        }

                        if ("messages".equals(fieldname)) {

                            //jParser.nextToken(); // current token is "[", move next
                            if (jParser.nextToken() == JsonToken.START_ARRAY) {
                                // messages is array, loop until token equal to "]"
                                while (jParser.nextToken() != JsonToken.END_ARRAY) {
                                    System.out.println(jParser.getText());
                                }
                            }

                        }

                    }

                }
            }           
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

```
Output >>>
----------

alejo
123
msg 1
msg 2
msg 3
alejo2
123
msg a
msg b
msg c
```