package com.leetcode.tree.segment;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MyCalendarTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                arguments(new int[][] {{10, 20}, {15, 25}, {20, 30}},
                        new boolean[] {true, false, true})
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testBook(int[][] events, boolean[] expected) {
        final MyCalendar myCalendar = new MyCalendar();
        boolean[] results = new boolean[events.length];
        int i = 0;
        for (int[] event : events) {
            results[i] = myCalendar.book(event[0], event[1]);
            i++;
        }
        assertArrayEquals(expected, results);
    }


}
