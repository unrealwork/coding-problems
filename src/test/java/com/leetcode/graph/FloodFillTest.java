package com.leetcode.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FloodFillTest {

    @Test
    void testFloodFill() {
        int[][] img = new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] res = FloodFill.floodFill(img, sr, sc, newColor);
        Assertions.assertArrayEquals(res, new int[][] {
                {2, 2, 2}, {2, 2, 0}, {2, 0, 1}
        });
    }
}
