package com.leetcode.tree;

public final class RangeSumBST {
    private RangeSumBST() {
    }

    public static int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val < low) {
            return rangeSumBST(node.right, low, high);
        }
        if (node.val > high) {
            return rangeSumBST(node.left, low, high);
        }
        return node.val + rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
    }

}
