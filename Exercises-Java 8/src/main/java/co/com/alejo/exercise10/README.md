
# Stream.iterate example
---

## Example 1 

Show streams of (0 -9)

```java
//Stream.iterate(initial value, next value)
    Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(x -> System.out.println(x));
```

## Example 2

Show a classic Fibonacci example

```java
Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
        .limit(20)
        .map(n -> n[0])
        .forEach(x -> System.out.println(x));
```


Sum all the Fibonacci values.

```java
int sum = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(n -> n[0]) // Stream<Integer>
                .mapToInt(n -> n)
                .sum();

        System.out.println("Fibonacci 10 sum : " + sum);
```

## Example in Java 9


The **stream.iterate** was enhanced in Java 9. It supports a predicate (condition) as second argument, and the stream.iterate will stop if the predicate is false.

Stop the stream iteration if n >= 20

```java
Stream.iterate(1, n -> n < 20 , n -> n * 2)
           .forEach(x -> System.out.println(x));
```

```
Output >>>>

1
2
4
8
16
```