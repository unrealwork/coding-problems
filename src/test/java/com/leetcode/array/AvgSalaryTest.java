package com.leetcode.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AvgSalaryTest {

    @ParameterizedTest
    @CsvSource( {
            "'4000,3000,1000,2000', 2500",
            "'1000,2000,3000', 2000",
    })
    void testAverage(@ConvertWith(IntArrayConverter.class) int[] arr, double res) {
        assertEquals(res, AvgSalary.average(arr), 10e-6);
    }
}
