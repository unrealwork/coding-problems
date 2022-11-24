package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public final class SortIntegersByBitNum {
    private SortIntegersByBitNum() {
    }

    public static int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted(Comparator.comparing(Integer::bitCount).thenComparing(Function.identity()))
                .mapToInt(a -> a)
                .toArray();
    }
}
