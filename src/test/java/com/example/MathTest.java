package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MathTest {
    @Test()
    void testExact() {
        final ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> Math.addExact(Integer.MAX_VALUE, 1));
        assertEquals("integer overflow", exception.getMessage());
    }

    @Test
    void testNonExact() {
        final int result = Integer.MAX_VALUE + 1;
        assertEquals(Integer.MIN_VALUE, result);
    }
}
