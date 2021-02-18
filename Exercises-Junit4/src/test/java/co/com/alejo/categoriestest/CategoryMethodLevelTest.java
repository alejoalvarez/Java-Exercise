package co.com.alejo.categoriestest;

import co.com.alejo.categories.PerformanceTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CategoryMethodLevelTest {

    @Category(PerformanceTest.class)
    @Test
    public void test_a_1() {
        assertThat(1 == 1, is(true));
    }

    @Test
    public void test_a_2() {
        assertThat(1 == 1, is(true));
    }
}
