package co.com.alejo.expectedexceptions;

import org.junit.Test;

import java.util.ArrayList;

public class Example1Test {

    @Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        int i = 1 / 0;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyList() {
        new ArrayList<>().get(0);
    }
}
