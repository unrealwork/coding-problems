package com.leetcode.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneSwapEqualTest {

    @ParameterizedTest
    @CsvSource( {
            "bank,kanb,true",
            "attack,defend,false",
            "kelb,kelb,true",
            "kelb,kekb,false",
            "bank,kanr,false",
            "siyolsdcjthwsiplccpbuceoxmjjgrauocx,siyolsdcjthwsiplccjbuceoxmpjgrauocx,true",
            "glb,bdg,false"
    })
    void testAreAlmostEqual(String s1, String s2, boolean expected) {
        assertEquals(expected, OneSwapEqual.areAlmostEqual(s1, s2));
    }
}
