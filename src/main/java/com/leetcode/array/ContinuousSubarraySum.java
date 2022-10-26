package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public final class ContinuousSubarraySum {
    private ContinuousSubarraySum() {
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int modulo = sum % k;
            if (modulo == 0 && i > 0) {
                return true;
            } else {
                if (map.containsKey(modulo)) {
                    int index = map.get(modulo);
                    if (i - index > 1) {
                        return true;
                    }
                }
            }
            if (!map.containsKey(modulo)) {
                map.put(modulo, i);
            }
        }
        return false;
    }
}
