package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public final class BinaryTreeInorderTraversal {
    private BinaryTreeInorderTraversal() {
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traverse(root, list);
        return list;
    }

    private static void traverse(final TreeNode node, List<Integer> list) {
        if (node != null) {
            traverse(node.left, list);
            list.add(node.val);

            traverse(node.right, list);
        }
    }
}
