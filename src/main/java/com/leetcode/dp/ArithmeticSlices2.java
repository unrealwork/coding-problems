package com.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public final class ArithmeticSlices2 {
    private ArithmeticSlices2() {
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        Map<Long, Map<Integer, Integer>>[] diffMap = new Map[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            diffMap[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) num - nums[j];
                Map<Integer, Integer> curSeq = diffMap[i].computeIfAbsent(diff, k -> new HashMap<>());
                curSeq.computeIfPresent(2, (k, v) -> v + 1);
                curSeq.putIfAbsent(2, 1);
                if (diffMap[j].containsKey(diff)) {
                    for (Map.Entry<Integer, Integer> seqLen : diffMap[j].get(diff).entrySet()) {
                        int newSeqLen = seqLen.getKey() + 1;
                        curSeq.computeIfPresent(newSeqLen, (k, v) -> v + seqLen.getValue());
                        curSeq.putIfAbsent(newSeqLen, seqLen.getValue());
                        if (newSeqLen > 2) {
                            total += seqLen.getValue();
                        }
                    }
                }
            }
        }
        return total;
    }
}
