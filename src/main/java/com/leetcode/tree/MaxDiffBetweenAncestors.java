package com.leetcode.tree;

public final class MaxDiffBetweenAncestors {
    private MaxDiffBetweenAncestors() {
    }

    public static int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private static int dfs(TreeNode root, int curMin, int curMax) {
        if (root != null) {
            int nextMin = Math.min(curMin, root.val);
            int nextMax = Math.max(curMax, root.val);
            int bestLeft = dfs(root.left, nextMin, nextMax);
            int bestRight = dfs(root.right, nextMin, nextMax);
            return Math.max(bestLeft, bestRight);
        }
        return curMax - curMin;
    }

}
