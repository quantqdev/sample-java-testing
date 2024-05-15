package com.example;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ComparatorTest {
    @Mock
    Basics basics;

    @InjectMocks
    Comparator comparator;

    @Test
    void testCompare_WhenBasicsReturn0_ReturnEqualMessage() {
        // arrange / given
        when(basics.compare(1, 2)).thenReturn(0);

        // act / when
        final String actual = comparator.compare(1, 2);

        // assert / then
        verify(basics).compare(1, 2);
        Assertions.assertEquals("1 is equal to 2", actual);
    }

    @Test
    void testCompare_WhenBasicsReturn0_ReturnGreaterMessage() {
        // arrange / given
        when(basics.compare(1, 2)).thenReturn(1);

        // act / when
        final String actual = comparator.compare(1, 2);

        // assert / then
        Assertions.assertEquals("1 is greater than 2", actual);
    }

    @Test
    void testCompare_WhenBasicsReturn0_ReturnLessMessage() {
        // arrange / given
        when(basics.compare(1, 2)).thenReturn(-1);

        // act / when
        final String actual = comparator.compare(1, 2);

        // assert / then
        Assertions.assertEquals("1 is less than 2", actual);
    }

}
