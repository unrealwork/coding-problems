package com.leetcode.tree;

public final class PathSum3 {
    private PathSum3() {
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        } else {
            return countPathSum(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        }
    }

    private static int countPathSum(TreeNode root, int targetSum, long sum) {
        if (root == null) {
            return 0;
        }
        long curSum = sum + root.val;
        int c = 0;
        if (curSum == targetSum) {
            c = 1;
        }
        return c + countPathSum(root.left, targetSum, curSum) + countPathSum(root.right, targetSum, curSum);
    }
}
