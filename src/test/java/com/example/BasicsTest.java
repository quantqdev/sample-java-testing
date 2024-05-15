package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @CsvSource({ "1,1", "2,2", "-1,-1", "100,100" })
    void testCompare_WhenEquals_Return0(int n1, int n2) {
        // arrange / given
        final Basics basics = new Basics();

        // act / when
        final int actual = basics.compare(n1, n2);

        // assert / then
        Assertions.assertEquals(0, actual);
    }

    @ParameterizedTest
    @MethodSource("testCompare_WhenLessThan_ReturnNegative1_Arguments")
    void testCompare_WhenLessThan_ReturnNegative1(int n1, int n2) {
        // arrange / given
        final Basics basics = new Basics();

        // act / when
        final int actual = basics.compare(n1, n2);

        // assert / then
        Assertions.assertEquals(-1, actual);
    }

    private static Stream<Arguments> testCompare_WhenLessThan_ReturnNegative1_Arguments() {
        final List<Arguments> arguments = new ArrayList<>();

        for (int i : new int[] { 0, 1, 2, 3 }) {
            arguments.add(Arguments.of(Integer.MIN_VALUE, i));
            arguments.add(Arguments.of(i, Integer.MAX_VALUE));
        }

        return arguments.stream();
    }
}
