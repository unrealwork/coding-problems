package com.leetcode.twoheaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianFinderTest {

    public static final double EPS = 10e-6;

    @Test
    @DisplayName("Testing MedianFinder API")
    void test() {
        final MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        assertEquals(1, finder.findMedian(), EPS);
        finder.addNum(2);
        assertEquals(1.5, finder.findMedian(), EPS);
        finder.addNum(3);
        assertEquals(2, finder.findMedian(), EPS);
        finder.addNum(-1);
        assertEquals(1.5, finder.findMedian(), EPS);
        finder.addNum(-3);
        assertEquals(1, finder.findMedian(), EPS);
    }
}
