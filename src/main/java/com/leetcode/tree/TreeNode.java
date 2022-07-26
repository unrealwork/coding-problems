package com.leetcode.tree;

import java.util.Objects;

@SuppressWarnings("checkstyle:visibilitymodifier")
final class TreeNode {
    final int val;
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

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode) {
            return isSameTree(this, (TreeNode) obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
