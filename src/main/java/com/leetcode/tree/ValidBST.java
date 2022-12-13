package com.leetcode.tree;

public final class ValidBST {
    private ValidBST() {
    }

    static boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean check(TreeNode node, int min, int max) {
        return node == null || node.val > min && node.val < max
                && check(node.left, min, node.val)
                && check(node.right, node.val, max);
    }
}
