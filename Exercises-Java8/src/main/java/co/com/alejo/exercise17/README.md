
# StringJoiner examples
---

## Example 1 - StringJoiner

Join String by a delimiter 

```java
StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString(); //aaa,bbb,ccc
```

Join String by a delimiter and starting with a supplied prefix and ending with a supplied suffix.

```java
StringJoiner sj = new StringJoiner("/", "prefix-", "-suffix");
        sj.add("2016");
        sj.add("02");
        sj.add("26");
        String result = sj.toString(); //prefix-2016/02/26-suffix
```

## Example 2 - String.join

StringJoiner is used internally by static **String.join().**

Join String by a delimiter.

```
 String result = String.join("-", "2015", "10", "31" ); //2015-10-31
```

Join a List by a delimiter.

```
List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
 	//java, python, nodejs, ruby
    String result = String.join(", ", list);
```

## Example 3 - String.join

Join **List<String>** example.

```
List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
String result = list.stream().map(x -> x).collect(Collectors.joining(" | ")); //java | python | nodejs | ruby
```

Join **List<Object>** example.

```java
void test(){

        List<Game> list = Arrays.asList(
                new Game("Dragon Blaze", 5),
                new Game("Angry Bird", 5),
                new Game("Candy Crush", 5)
        );

        //{Dragon Blaze, Angry Bird, Candy Crush}
        String result = list.stream().map(x -> x.getName())
            .collect(Collectors.joining(", ", "{", "}"));
        
    }
    
    class Game{
        String name;
        int ranking;

        public Game(String name, int ranking) {
            this.name = name;
            this.ranking = ranking;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }
    }
```






