package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public final class MaxProductOfSplittedBinaryTree {
    private static final int MODULO = 1000000007;

    private MaxProductOfSplittedBinaryTree() {
    }

    public static int maxProduct(TreeNode root) {
        final List<Integer> sums = new ArrayList<>();
        final int sum = root.val + fillSums(root.left, sums) + fillSums(root.right, sums);
        long maxProduct = -1;
        for (long leftSum : sums) {
            maxProduct = Math.max(maxProduct, (sum - leftSum) * leftSum);
        }
        return (int) (maxProduct % MODULO);
    }

    private static int fillSums(TreeNode node, List<Integer> sums) {
        if (node == null) {
            return 0;
        } else {
            int sum = node.val + fillSums(node.left, sums) + fillSums(node.right, sums);
            sums.add(sum);
            return sum;
        }
    }
}
