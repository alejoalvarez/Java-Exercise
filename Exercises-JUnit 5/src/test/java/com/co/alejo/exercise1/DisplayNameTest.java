package com.co.alejo.exercise1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("I'm a Test Class")
 class DisplayNameTest {

    @Test
    @DisplayName("Test 1")
    public void test1() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
    }

}
