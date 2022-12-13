package com.leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public final class CombinationSum2 {
    private CombinationSum2() {
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combs = new ArrayList<>();
        Arrays.sort(candidates);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i == 0 || candidates[i] != candidates[i - 1]) {
                deque.addLast(candidates[i]);
                findCombinations(candidates, target, i, candidates[i], deque, combs);
                deque.removeLast();
            }
        }
        return combs;
    }

    private static void findCombinations(int[] candidates, int target, int elementIndex, int curSum, Deque<Integer> curPath, List<List<Integer>> combs) {
        if (curSum == target) {
            combs.add(List.copyOf(curPath));
        } else {
            if (elementIndex < candidates.length && curSum < target) {
                for (int i = elementIndex + 1; i < candidates.length; i++) {
                    if (i == elementIndex + 1 || candidates[i] != candidates[i - 1]) {
                        curPath.addLast(candidates[i]);
                        findCombinations(candidates, target, i, curSum + candidates[i], curPath, combs);
                        curPath.removeLast();
                    }
                }
            }
        }
    }
}
