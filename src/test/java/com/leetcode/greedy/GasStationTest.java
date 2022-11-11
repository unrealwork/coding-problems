package com.leetcode.greedy;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class GasStationTest {

    @ParameterizedTest
    @CsvSource( {
            "'1,2,3,4,5', '3,4,5,1,2', 3",
            "'2,3,4', '3,4,3', -1",
            "'1,2,3,4,5,5,70', '2,3,4,3,9,6,2', 6"
    })
    void testCanCompleteCircuit(@ConvertWith(IntArrayConverter.class) int[] gas,
                                @ConvertWith(IntArrayConverter.class) int[] cost, int expected) {
        Assertions.assertEquals(expected, GasStation.canCompleteCircuit(gas, cost));
    }
}
