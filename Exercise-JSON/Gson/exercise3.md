# Example 3

```gradle
dependencies {
    compile group: 'com.google.code.gson', name: 'gson', version: '2.8.0'
}
```

```java
public class FootballPlayer {

    private int dorsal;
    private String name;
    private List demarcation;
    private String team;

    public FootballPlayer(int dorsal, String name, List demarcation,
            String team) {
        this.dorsal = dorsal;
        this.name = name;
        this.demarcation = demarcation;
        this.team = team;
    }

    // getter y setter

    @Override
    public String toString() {
        return "Dorsal=" + dorsal + ", Name=" + name + ", Demarcation="
                + demarcation + ", Team=" + team;
    }
}
```

An example of how we would pass this JSON to an object of type «FootballPlayer» in a "manual" way would be the following:

```java
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReadJson1 {

    public static void main(String[] args) {

        String json1 = "[{\"dorsal\":10," + "\"name\":\"Messi\","
                + "\"demarcation\":[\"left winger\",\"Midfielder\"],"
                + "\"team\":\"FC Barcelona\"}]";

        JsonParser parser = new JsonParser();

        // Obtain Array
        JsonArray gsonArr = parser.parse(json1).getAsJsonArray();

        // for each element of array
        for (JsonElement obj : gsonArr) {

            // Object of array
            JsonObject gsonObj = obj.getAsJsonObject();

            // Primitives elements of object
            int dorsal = gsonObj.get("dorsal").getAsInt();
            String name = gsonObj.get("name").getAsString();
            String team = gsonObj.get("team").getAsString();

            // List of primitive elements
            JsonArray demarcation = gsonObj.get("demarcation").getAsJsonArray();
            List listDemarcation = new ArrayList();
            for (JsonElement demarc : demarcation) {
                listDemarcation.add(demarc.getAsString());
            }

            // Object Constructor
            FootballPlayer iniesta = new FootballPlayer(dorsal, name,
                    listDemarcation, team);
            System.out.println(iniesta);
        }
    }
}
```

There is a much easier way to parse (or deserialize) a JSON without having to map element by element of the object. The simple thing is that given a class and a JSON, this will be parsed automatically

```java
import com.google.gson.Gson;

public class ReadJson2 {

    public static void main(String[] args) {

         String jsonAll = "[{\"dorsal\":3,\"name\":\"Pique\",\"demarcation\":[\"Centre-back\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":5,\"name\":\"Puyol\",\"demarcation\":[\"Centre-back\"],\"team\":\"FC Barcelona\"},"                                
                + "{\"dorsal\":16,\"name\":\"Busquets\",\"demarcation\":[\"Defensive midfield\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":8,\"name\":\"Xavi Hernandez\",\"demarcation\":[\"Midfielder\"],\"team\":\"FC Barcelona\"},"                
                + "{\"dorsal\":6,\"name\":\"Iniesta\",\"demarcation\":[\"Right winger\",\"Midfielder\"],\"team\":\"FC Barcelona\"},"
                + "{\"dorsal\":7,\"name\":\"Villa\",\"demarcation\":[\"Centre forward\"],\"team\":\"FC Barcelona\"}]";


        Gson gson = new Gson();s
        FootballPlayer[] footballPlayers = gson.fromJson(jsonAll,
                FootballPlayer[].class);

        for (FootballPlayer footballPlayer : footballPlayers) {
            System.out.println(footballPlayer);
        }
    }
}
```

let's see the opposite example of serialization of a series of objects of the FootballPlayer class to a JSON

```java
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

public class WriteJson {

	public static void main(String[] args) {
		
		List spanishTeam = Arrays.asList(				
			new FootballPlayer(3, "Pique", Arrays.asList("Centre-back"), "FC Barcelona"),
			new FootballPlayer(5, "Puyol", Arrays.asList("Centre-back"), "FC Barcelona"),						
			new FootballPlayer(16, "Busquets", Arrays.asList("Defensive midfield"), "FC Barcelona"),
			new FootballPlayer(8, "Xavi Hernandez", Arrays.asList("Midfielder"), "FC Barcelona"),			
			new FootballPlayer(6, "Iniesta", Arrays.asList("Right winger", "Midfielder"), "FC Barcelona"),
			new FootballPlayer(7, "Villa", Arrays.asList("Centre forward"), "FC Barcelona")
				);
		
		String json = new Gson().toJson(spanishTeam);
		System.out.println(json);
		
	}
}
```