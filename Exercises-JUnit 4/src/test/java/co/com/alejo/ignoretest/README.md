# Ignore test
---

**Question**: To ignore a test, why not just comment the test methods or @Test annotation?

**Answer**: The test runner will not report the test. In IDE, the test runner will display the ignored tests with different icon or color, and highlight it, so that you know what tests are ignored.

**Question**: Why make a test that doesn’t test?

**Answer** : For large project, many developers are handling different modules, the failed test may caused by other teams, you can add @Ignore on the test method to avoid the test to break the entire build process, Or you want someone to help to create the test, like @Ignore ("help for this method!"), the optional parameter(String) will be displayed in the test runner.