package com.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MirrorReflectionTest {


    @ParameterizedTest
    @CsvSource( {"2,1,2", "3,1,1", "3,2,0"})
    void testMirrorReflection(int p, int q, int expected) {
        int actual = MirrorReflection.mirrorReflection(p, q);
        Assertions.assertEquals(expected, actual);
    }
}
