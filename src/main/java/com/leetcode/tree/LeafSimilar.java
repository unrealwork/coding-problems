package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public final class LeafSimilar {
    private LeafSimilar() {
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leaves(root1).equals(leaves(root2));
    }

    private static List<Integer> leaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        fillLeaves(root, leaves);
        return leaves;
    }

    private static void fillLeaves(TreeNode node, List<Integer> leaves) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leaves.add(node.val);
            } else {
                fillLeaves(node.left, leaves);
                fillLeaves(node.right, leaves);
            }
        }
    }
}
