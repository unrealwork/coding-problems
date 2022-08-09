package com.leetcode.tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class BinaryTreeWithFactors {
    private static final int MODULO = 1000000007;

    private BinaryTreeWithFactors() {
    }

    public static int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, List<int[]>> factorsDict = factorsCountDict(arr);
        int count = 0;
        Map<Integer, Integer> memo = new HashMap<>(arr.length);
        for (int e : arr) {
            count += numFactoredBinaryTreesRec(e, factorsDict, memo);
            count %= MODULO;
        }
        return count;
    }

    private static int numFactoredBinaryTreesRec(int e, Map<Integer, List<int[]>> factorsDict, Map<Integer, Integer> memo) {
        if (memo.containsKey(e)) {
            return memo.get(e);
        }
        List<int[]> factors = factorsDict.get(e);
        if (factors.isEmpty()) {
            memo.put(e, 1);
            return 1;
        } else {
            int res = 1;
            for (int[] f : factors) {
                long leftChildCount = numFactoredBinaryTreesRec(f[0], factorsDict, memo);
                long rightChildCount = numFactoredBinaryTreesRec(f[1], factorsDict, memo);
                int reduced = (int) ((leftChildCount * rightChildCount) % MODULO);
                res += reduced;
                res %= MODULO;
            }
            memo.put(e, res);
            return res;
        }
    }

    private static Map<Integer, List<int[]>> factorsCountDict(int[] arr) {
        Map<Integer, List<int[]>> map = new HashMap<>(arr.length);
        for (int e : arr) {
            map.put(e, new LinkedList<>());
        }
        for (int e : arr) {
            long sqr = (long) e * e;
            if (sqr <= Integer.MAX_VALUE) {
                map.computeIfPresent(e * e, (k, v) -> {
                    v.add(new int[] {e, e});
                    return v;
                });
            }
        }
        for (int a : arr) {
            for (int b : arr) {
                if (a > b) {
                    long mult = (long) a * b;
                    if (mult <= Integer.MAX_VALUE) {
                        map.computeIfPresent(a * b, (k, v) -> {
                            Collections.addAll(v, new int[] {a, b}, new int[] {b, a});
                            return v;
                        });
                    }
                }
            }
        }
        return map;
    }
}
