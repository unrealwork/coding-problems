package com.leetcode.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BasicCalculatorTest {

    @ParameterizedTest
    @CsvSource( {
            "'1 + 1', 2",
            "'-(2 + 3)', -5",
            "' 2-1 + 2 ', 3",
            "'(1+(4+5+2)-3)+(6+8)', 23",
            "'(1+(4+5+2)-3)+(6-8)', 7",
            "'(1+(4+5+2)-3)-(6+8)', -5",
            "'(1+(4+5+2)-3)-(6-8)', 11",
            "'2-4-(8+2-6+(8+4-(1)+8-10))',-15"
    })
    void testCalculate(String expr, int res) {
        Assertions.assertEquals(res, BasicCalculator.calculate(expr));
    }
}
