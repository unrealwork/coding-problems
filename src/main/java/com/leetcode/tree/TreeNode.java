package com.leetcode.tree;

@SuppressWarnings("checkstyle:visibilitymodifier")
final class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int v) {
        this.val = v;
    }

    TreeNode(int v, TreeNode leftNode, TreeNode rightNode) {
        this.val = v;
        this.left = leftNode;
        this.right = rightNode;
    }
}
