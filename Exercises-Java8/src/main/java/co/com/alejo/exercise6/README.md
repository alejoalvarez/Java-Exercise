
# Find duplicate elements in Streams
---

### Example 1
---
Filter and Set.add()

The **Set.add()** returns false if the element was already in the set; let see the benchmark at the end of the article.


### Example 2
---

Map and Collectors.groupingBy

Create a **Map** by **Collectors.groupingBy** and find elements that count > 1.


### Example 3
---

Collections.frequency

It compares each item with a list – **Collections.frequency(list, i)**.



