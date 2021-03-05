package co.com.alejo.categoriestest;

import co.com.alejo.categories.PerformanceTest;
import co.com.alejo.categories.RegressionTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Category({PerformanceTest.class, RegressionTest.class})
public class CategoryClassLevelTest {

    @Test
    public void test_b_1() {
        assertThat(1 == 1, is(true));
    }
}
