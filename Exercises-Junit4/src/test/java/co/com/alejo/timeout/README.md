# Timeout examples
---

## Example 1

This timeout example only applies to a single test method. And the timeout value is in milliseconds.

This timeout test is useful to test on the method performance. see class **TimeoutExample1Test**

## Example 2

This example shows you how to create a global timeout rule, this rule will apply to all the test methods in a class.

In the above example, a global Timeout rule is declared, both the testSlowMethod1() and testSlowMethod2() must finish the test within 1 second, else the test will be failed.

The rule also applies on @Before and @After methods. see class **TimeoutExample2Test**


