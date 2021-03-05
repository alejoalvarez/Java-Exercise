package com.co.alejo.exercise4;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AssertJTest {

    // assert string
    @Test
    void test_string_ok() {

        String name = "Alejo!";

        assertThat(name)
                .as("if failed display this msg!")
                .isEqualTo("Alejo!")
                .isEqualToIgnoringCase("alejo!")
                .startsWith("A")
                .endsWith("!")
                .containsIgnoringCase("alejo");
    }

    // assert list
    @Test
    void test_list_ok() {

        List<String> list = Arrays.asList("Java", "node", "python");

        assertThat(list)
                .hasSize(3)
                .contains("Java", "python")
                .contains("Java", Index.atIndex(0))
                .contains("node", Index.atIndex(1))
                .contains("python", Index.atIndex(2))
                .doesNotContain("Node JS");
    }

    // assert map
    @Test
    void test_map_ok() {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "alejo");

        assertThat(map)
                .hasSize(1)
                .extractingByKey("name", as(InstanceOfAssertFactories.STRING))
                .isEqualToIgnoringCase("alejo")
                .startsWith("alejo");

        assertThat(map).extracting("name")
                .isEqualTo("alejo");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("number", 999);

        assertThat(map2)
                .hasSize(1)
                .extractingByKey("number", as(InstanceOfAssertFactories.INTEGER))
                .isEqualTo(999);
    }

    // assert exception
    @Test
    void test_exception_ok() {

        assertThatThrownBy(() -> divide(1, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("zero")
                .hasMessage("divide by zero");

        assertThatThrownBy(() -> {
            List<String> list = Arrays.asList("one", "two");
            list.get(2);
        })
                .isInstanceOf(Throwable.class)
                .hasMessageContaining("Array index out of range: 2");
    }

    int divide(int input, int divide) {
        return input / divide;
    }
}
