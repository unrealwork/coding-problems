package com.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RectangleAreaTest {

    @SuppressWarnings("checkstyle:ParameterNumber")
    @ParameterizedTest
    @CsvSource( {
            "-2,-2,2,2,-2,-2,2,2,16",
            "-3,0,3,4,0,-1,9,2,45"
    })
    void testComputeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2, int expected) {
        Assertions.assertEquals(expected, RectangleArea.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}
