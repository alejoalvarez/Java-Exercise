
# Parallel streams examples
---

## Example 1 

A simple parallel example to print 1 to 10. see class **BaseStreamParallel**

```
Output >>>

Normal...
1
2
3
4
5
6
7
8
9
10

Parallel...
7
6
8
9
10
1
4
5
3
2
```
## Example 2

Another simple parallel example to print a to z. For collection, we can use **parallelStream().** see class **CollectionParallelStream**

The Output parallel stream can change.
```
Normal...
a
b
c
d
e
f
g
h
i
j
k
l
m
n
o
p
q
r
s
t
u
v
w
x
y
z
Parallel...
q
s
r
o
x
h
l
p
d
i
g
t
u
n
z
v
j
k
w
f
m
c
a
e
b
y
```

