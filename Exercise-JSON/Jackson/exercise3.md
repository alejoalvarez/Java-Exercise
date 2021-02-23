# Jackon TreeModel Example

## Example1 complex json 

```json
C:\\projects\\user.json

{
  "id": 1,
  "name": {
    "first": "alejo",
    "last": "alvarez"
  },
  "contact": [
    {
      "type": "phone/home",
      "ref": "123-456-789"
    },
    {
      "type": "phone/work",
      "ref": "1212-1234-2345"
    }
  ]
}
```

Process JsonNode one by one

```java
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonTreeModel {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        try {

            JsonNode root = mapper.readTree(new File("c:\\projects\\user.json"));

            // Get id
            long id = root.path("id").asLong();
            System.out.println("id : " + id);

            // Get Name
            JsonNode nameNode = root.path("name");
            if (!nameNode.isMissingNode()) {        // if "name" node is exist
                System.out.println("firstName : " + nameNode.path("first").asText());
                System.out.println("middleName : " + nameNode.path("middle").asText());
                System.out.println("lastName : " + nameNode.path("last").asText());
            }

            // Get Contact
            JsonNode contactNode = root.path("contact");
            if (contactNode.isArray()) {

                System.out.println("Is this node an Array? " + contactNode.isArray());

                for (JsonNode node : contactNode) {
                    String type = node.path("type").asText();
                    String ref = node.path("ref").asText();
                    System.out.println("type : " + type);
                    System.out.println("ref : " + ref);
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
id : 1

firstName : alejo
middleName : 
lastName : alvarez

Is this node an Array? true
type : phone/home
ref : 123-456-789"
type : phone/work
ref : 1212-1234-2345
```

## Example2 complex json with several records.

```json
[
  {
    "id": 1,
    "name": {
      "first": "alejo1",
      "last": "alvarez1"
    },
    "contact": [
      {
        "type": "phone/home",
        "ref": "111-111-1111"
      },
      {
        "type": "phone/work",
        "ref": "222-222-2222"
      }
    ]
  },
  {
    "id": 2,
    "name": {
      "first": "alejo2",
      "last": "alvarez2"
    },
    "contact": [
      {
        "type": "phone/home",
        "ref": "222-222-2222"
      },
      {
        "type": "phone/work",
        "ref": "444-444-4444"
      }
    ]
  }
]
```

```java
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonTreeModel {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        try {

            JsonNode rootArray = mapper.readTree(new File("c:\\projects\\user2.json"));

            for (JsonNode root : rootArray) {

                // Get id
                long id = root.path("id").asLong();
                System.out.println("id : " + id);

                // Get Name
                JsonNode nameNode = root.path("name");
                if (!nameNode.isMissingNode()) {        // if "name" node is exist
                    System.out.println("firstName : " + nameNode.path("first").asText());
                    System.out.println("middleName : " + nameNode.path("middle").asText());
                    System.out.println("lastName : " + nameNode.path("last").asText());
                }

                // Get Contact
                JsonNode contactNode = root.path("contact");
                if (contactNode.isArray()) {

                    System.out.println("Is this node an Array? " + contactNode.isArray());

                    for (JsonNode node : contactNode) {
                        String type = node.path("type").asText();
                        String ref = node.path("ref").asText();
                        System.out.println("type : " + type);
                        System.out.println("ref : " + ref);
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

id : 1
firstName : alejo1
middleName : 
lastName : alvarez1
Is this node an Array? true
type : phone/home
ref : 111-111-1111
type : phone/work
ref : 222-222-2222

id : 2
firstName : alejo2
middleName : 
lastName : alvarez2
Is this node an Array? true
type : phone/home
ref : 222-222-2222
type : phone/work
ref : 444-444-4444
```

## Tree model CRUD

This example, show you how to create, update and remove JSON nodes, to modify JSON node, we need to convert it to ObjectNode. Read the comments for self-explanatory.

```java
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JacksonTreeModelCrud {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        try {

            JsonNode root = mapper.readTree(new File("c:\\projects\\user.json"));

            String resultOriginal = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
            System.out.println("Before Update " + resultOriginal);

            // 1. Update id to 1000
            ((ObjectNode) root).put("id", 1000L);

            // 2. If middle name is empty , update to M
            ObjectNode nameNode = (ObjectNode) root.path("name");
            if ("".equals(nameNode.path("middle").asText())) {
                nameNode.put("middle", "M");
            }

            // 3. Create a new field in nameNode
            nameNode.put("nickname", "alejo");

            // 4. Remove last field in nameNode
            nameNode.remove("last");

            // 5. Create a new ObjectNode and add to root
            ObjectNode positionNode = mapper.createObjectNode();
            positionNode.put("name", "Developer");
            positionNode.put("years", 8);
            ((ObjectNode) root).set("position", positionNode);

            // 6. Create a new ArrayNode and add to root
            ArrayNode gamesNode = mapper.createArrayNode();

            ObjectNode game1 = mapper.createObjectNode().objectNode();
            game1.put("name", "Fifa");
            game1.put("price", 220000);

            ObjectNode game2 = mapper.createObjectNode().objectNode();
            game2.put("name", "Mario");
            game2.put("price", 50000);

            gamesNode.add(game1);
            gamesNode.add(game2);
            ((ObjectNode) root).set("games", gamesNode);

            // 7. Append a new Node to ArrayNode
            ObjectNode email = mapper.createObjectNode();
            email.put("type", "email");
            email.put("ref", "abc@alejo.com");

            JsonNode contactNode = root.path("contact");
            ((ArrayNode) contactNode).add(email);

            String resultUpdate = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
            
            System.out.println("After Update " + resultUpdate);

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
Before Update {
  "id" : 1,
  "name" : {
    "first" : "alejo",
    "last" : "alvarez"
  },
  "contact" : [ {
    "type" : "phone/home",
    "ref" : "111-111-11111"
  }, {
    "type" : "phone/work",
    "ref" : "222-222-2222"
  } ]
}

After Update {
  "id" : 1000,
  "name" : {
    "first" : "alejo",
    "middle" : "M",
    "nickname" : "alejo1"
  },
  "contact" : [ {
    "type" : "phone/home",
    "ref" : "111-111-1111"
  }, {
    "type" : "phone/work",
    "ref" : "222-222-2222"
  }, {
    "type" : "email",
    "ref" : "abc@alejo.com"
  } ],
  "position" : {
    "name" : "Developer",
    "years" : 8
  },
  "games" : [ {
    "name" : "Fifa",
    "price" : 220000
  }, {
    "name" : "Mario",
    "price" : 50000
  } ]
}
```