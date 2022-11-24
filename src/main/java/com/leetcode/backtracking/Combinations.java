package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class Combinations {
    private Combinations() {

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        addCombinations(n, k, 0, new LinkedList<>(), res);
        return res;
    }

    private static void addCombinations(int n, int k, int curNum, LinkedList<Integer> combination, List<List<Integer>> combinations) {
        if (combination.size() < k) {
            for (int i = curNum + 1; i <= n; i++) {
                combination.addLast(i);
                addCombinations(n, k, i, combination, combinations);
                combination.removeLast();
            }
        } else {
            combinations.add(new ArrayList<>(combination));
        }
    }
}
