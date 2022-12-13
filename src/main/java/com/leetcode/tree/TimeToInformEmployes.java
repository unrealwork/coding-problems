package com.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TimeToInformEmployes {
    private TimeToInformEmployes() {

    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> tree = mapTree(n, manager);
        return maxDepth(headID, tree, informTime);
    }

    private static int maxDepth(Integer key, Map<Integer, List<Integer>> tree, int[] informTime) {
        List<Integer> children = tree.get(key);
        if (children == null) {
            return 0;
        } else {
            int max = 0;
            for (Integer child : children) {
                max = Math.max(max, maxDepth(child, tree, informTime));
            }
            return max + informTime[key];
        }
    }

    private static Map<Integer, List<Integer>> mapTree(int n, int[] manager) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = manager[i];
            res.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
        }
        return res;
    }
}
