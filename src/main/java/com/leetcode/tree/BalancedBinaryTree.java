package com.leetcode.tree;

public final class BalancedBinaryTree {
    private BalancedBinaryTree() {
    }

    public static boolean isBalanced(TreeNode root) {
        return getHeightIfBalanced(root) != -1;
    }

    private static int getHeightIfBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeightIfBalanced(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeightIfBalanced(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
