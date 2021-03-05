# Basic Annotations
---

JUnit 4 - Basic annotations

* @BeforeClass – Run once before any of the test methods in the class, public static void
* @AfterClass – Run once after all the tests in the class have been run, public static void
* @Before – Run before @Test, public void
* @After – Run after @Test, public void
* @Test – This is the test method to run, public void

```
Output >>>

@BeforeClass - runOnceBeforeClass

@Before - runBeforeTestMethod
@Test - test_method_1
@After - runAfterTestMethod

@Before - runBeforeTestMethod
@Test - test_method_2
@After - runAfterTestMethod

@AfterClass - runOnceAfterClass
```