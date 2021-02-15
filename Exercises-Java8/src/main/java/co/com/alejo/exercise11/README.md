
# Streams Collectors groupingBy examples
---

## Example 1 

Group by a List and display the total count of it. see class **GroupByCountAndSort**

## Example 2

Examples to ‘group by’ a list of user defined Objects. see class **GroupByListDefinedObject**

```
Output >>>

Quantity: {papaya=1, orange=1, banana=2, apple=3, watermelon=1}
Sum of quantity: {papaya=20, orange=10, banana=30, apple=40, watermelon=10}
```

## Example 3

Group by Price – Collectors.groupingBy

```
Output >>>
{19.99=[co.com.alejo.exercise11.Item@2a5cd2b5, co.com.alejo.exercise11.Item@bcf18ab], 29.99=[co.com.alejo.exercise11.Item@9d9064d7, co.com.alejo.exercise11.Item@6fc121e4], 9.99=[co.com.alejo.exercise11.Item@c6be4db5, co.com.alejo.exercise11.Item@502f580, co.com.alejo.exercise11.Item@514be442, co.com.alejo.exercise11.Item@a162b7d8]}
{19.99=[banana], 29.99=[orang, watermelon], 9.99=[papaya, apple]}
```

