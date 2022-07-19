package com.leetcode.tree;

final class MinDepthBinaryTree {
    private MinDepthBinaryTree() {
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        } else {
            return 1 + minDepth(root.left);
        }
    }
}
