package com.leetcode.tree;

import java.util.function.IntConsumer;

public final class BinaryTreeMaximumPathSum {
    private BinaryTreeMaximumPathSum() {
    }

    public static int maxPathSum(TreeNode root) {
        MaxHolder maxHolder = new MaxHolder();
        maxPath(root, maxHolder::update);
        return maxHolder.max;
    }

    private static int maxPath(TreeNode root, IntConsumer consumer) {
        if (root == null) {
            return 0;
        }

        int leftNodeMaxSum = maxPath(root.left, consumer);
        int rightNodeMaxSum = maxPath(root.right, consumer);
        int bestSum = Math.max(root.val, root.val + Math.max(leftNodeMaxSum, rightNodeMaxSum));
        consumer.accept(Math.max(bestSum, root.val + leftNodeMaxSum + rightNodeMaxSum));
        return bestSum;
    }

    private static class MaxHolder {
        private int max = Integer.MIN_VALUE;

        public void update(int val) {
            max = Math.max(val, max);
        }
    }
}
