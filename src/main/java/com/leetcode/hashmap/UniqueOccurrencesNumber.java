package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class UniqueOccurrencesNumber {
    private UniqueOccurrencesNumber() {
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : arr) {
            countMap.merge(n, 1, Integer::sum);
        }
        Set<Integer> values = new HashSet<>();
        for (Integer count : countMap.values()) {
            if (!values.add(count)) {
                return false;
            }
        }
        return true;
    }
}
