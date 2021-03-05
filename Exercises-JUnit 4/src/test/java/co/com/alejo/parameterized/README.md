# Parameterized Test
---

We can pass the parameters into the unit test method:

* via Constructor
* via fields injection **@Parameter**

## Example 1

Parameterized via constructor

## Example 2

Parameterized via filed injection. see class **ParameterizedFiledInjectionTest**

For @Parameters, the “name” attribute is optional, it helps you to identify individual test cases by providing a unique name.

What is {0}, {1} and {2}?
If the parameter is “{ 3, 4, 7 }”, then {0} = 3, {1} = 4, {2} = 7.