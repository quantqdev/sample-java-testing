package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicsTest {
    @Test
    void testCompare_WhenGreaterThan_Return1() {
        // arrange / given
        final Basics basics = new Basics();

        // act / when
        final int actual = basics.compare(2, 1);
        final int actual2 = basics.compare(Integer.MAX_VALUE, 1);
        final int actual3 = basics.compare(Integer.MAX_VALUE, Integer.MIN_VALUE);

        // assert / then
        Assertions.assertEquals(1, actual);
        Assertions.assertEquals(1, actual2);
        Assertions.assertEquals(1, actual3);
    }

    @Test
    void testCompare_WhenEquals_Return0() {
        // arrange / given
        final Basics basics = new Basics();

        // act / when
        final int actual = basics.compare(1, 1);

        // assert / then
        Assertions.assertEquals(0, actual);
    }

    @Test
    void testCompare_WhenLessThan_ReturnNegative1() {
        // arrange / given
        final Basics basics = new Basics();

        // act / when
        final int actual = basics.compare(1, 2);

        // assert / then
        Assertions.assertEquals(-1, actual);
    }
}
