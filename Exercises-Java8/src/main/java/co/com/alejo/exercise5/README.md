
# flatMap Example
---

## What is flatMap()?

Review this structure, It consists of a 2 levels Stream or a 2d arrays.

```
# Stream<String[]>
# Stream<Stream<String>>
# String[][]

[
  [1, 2],
  [3, 4],
  [5, 6]
]
```

In Java 8, we can use the flatMap to convert the above 2 levels Stream into one Stream level or a 2d array into a 1d array.

```
# Stream<String>
# String[]

[1, 2, 3, 4, 5, 6]
```

## Why flat a Stream?

It’s challenging to process a Stream containing more than one level, like **Stream<String[]>** or **Stream<List<LineItem>>** or **Stream<Stream<String>>**. And we flat the 2 levels Stream into one level, like **Stream<String>** or **Stream<LineItem>**, so that we can easily loop the Stream and process it.

Review the below example, before and after applying **flatMap** on a Stream.

2.2 Below is a 2d array, and we can use **Arrays.stream** or **Stream.of** to convert it into a Stream, and it produces a Stream of **String[]** or **Stream<String[]>**.

```
  String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

  // array to a stream
  Stream<String[]> stream1 = Arrays.stream(array);

  // same result
  Stream<String[]> stream2 = Stream.of(array);
```

or like this

```
[
  [a, b],
  [c, d],
  [e, f]
]
```

Here’s the requirement, we want to filter out the a and print out all the characters.

First, we try the **Stream#filter** directly. However, the below program will print nothing, and it is because the **x** inside the **Stream#filter** is a **String[]**, not a **String**; the condition will always remain false, and the Stream will collect nothing.

```java
String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

  // convert array to a stream
  Stream<String[]> stream1 = Arrays.stream(array);

  List<String[]> result = stream1
      .filter(x -> !x.equals("a"))      // x is a String[], not String!
      .collect(Collectors.toList());

  System.out.println(result.size());    // 0

  result.forEach(System.out::println);  // print nothing?
```

OK, this time, we refactor the filter method to deal with the **String[]**.

```java
String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

  // array to a stream
  Stream<String[]> stream1 = Arrays.stream(array);

  // x is a String[]
  List<String[]> result = stream1
          .filter(x -> {
              for(String s : x){      // really?
                  if(s.equals("a")){
                      return false;
                  }
              }
              return true;
          }).collect(Collectors.toList());

  // print array
  result.forEach(x -> System.out.println(Arrays.toString(x)));
```

```
Output >>>

[c, d]
[e, f]
```

In the above case, the **Stream#filter** will filter out the entire **[a, b]**, but we want to filter out only the character a

Below is the final version, and we combine the array first and follow by a filter later. In Java, to convert a 2d array into a 1d array, we can loop the 2d array and put all the elements into a new array; Or we can use the Java 8 **flatMap** to flatten the 2d array into a 1d array, or from **Stream<String[]>** to **Stream<String>**.

```java
String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

  // Java 8
  String[] result = Stream.of(array)  // Stream<String[]>
          .flatMap(Stream::of)        // Stream<String>
          .toArray(String[]::new);    // [a, b, c, d, e, f]

  for (String s : result) {
      System.out.println(s);
  }
```

```
Output >>>

a
b
c
d
e
f
```

Now, we can easily filter out the **a**; let see the final version.

```java
String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

  List<String> collect = Stream.of(array)     // Stream<String[]>
          .flatMap(Stream::of)                // Stream<String>
          .filter(x -> !"a".equals(x))        // filter out the a
          .collect(Collectors.toList());      // return a List

  collect.forEach(System.out::println);
```

```
Output >>

b
c
d
e
f
```

I want to point out that dealing with more than one level of Stream is challenging, confusing, and error-prone, and we can use this **Stream#flatMap** to flatten the 2 levels Stream into one level Stream.

```java
Stream<String[]>      -> flatMap ->	Stream<String>
Stream<Set<String>>   -> flatMap ->	Stream<String>
Stream<List<String>>  -> flatMap ->	Stream<String>
Stream<List<Object>>  -> flatMap ->	Stream<Object>
```

### Example 1
---
Find all books

This example uses **.stream()** to convert a **List** into a stream of objects, and each object contains a set of books, and we can use **flatMap** to produces a stream containing all the book in all the objects.

In the end, we also filter out the book containing the word **python** and collect a **Set** to remove the duplicated book.


### Example 2
---

Orden and LineItems

The **orders** is a stream of purchase orders, and each purchase order contains a collection of line items, then we can use **flatMap** to produce a Stream or **Stream<LineItem>** containing all the line items in all the orders. Furthermore, we also add a **reduce** operation to sum the line items’ total amount.

### Example 3
---

Primitive type

For primitive types like **int**, **long**, **double**, etc. Java 8 Stream also provide related **flatMapTo{primative type}** to flat the Stream of primitive type; the concept is the same.