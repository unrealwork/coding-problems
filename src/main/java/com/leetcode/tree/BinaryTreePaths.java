package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

final class BinaryTreePaths {
    private static final String ARROW = "->";

    private BinaryTreePaths() {

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        final List<String> res = new ArrayList<>();
        binaryTreePathsRec(root, "", res);
        return res;
    }

    private static void binaryTreePathsRec(TreeNode root, String s, List<String> res) {
        if (root != null) {
            String next;
            next = addToPath(root, s);
            if (root.left == null && root.right == null) {
                res.add(next);
            } else {
                binaryTreePathsRec(root.left, next, res);
                binaryTreePathsRec(root.right, next, res);
            }
        }
    }

    private static String addToPath(TreeNode root, String s) {
        if (s.isEmpty()) {
            return Integer.toString(root.val);
        }
        return s + ARROW + root.val;
    }
}
