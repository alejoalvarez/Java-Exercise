we can use ExecutorService to create a thread pool, and tracks the progress of the asynchronous tasks with Future.

The ExecutorService accept both Runnable and Callable tasks.

Runnable – Return void, nothing.
Callable – Return a Future.

1. ExecutorService
- A classic ExecutorService example to create a thread pool with 5 threads, submit two tasks, get the result from Future and also how to handle the exception.

Result:
```
I'm Runnable task.
I'm Callable task.
I'm other task! Before Future Result
Get future result : 2
I'm other task! After Future Result
```

2. invokeAll
- We can also create a list of Callable tasks, and run them all with invokeAll

Result
```
2
```
