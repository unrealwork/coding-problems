package com.leetcode.tree;

public final class SearchBST {
    private SearchBST() {
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}
