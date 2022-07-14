package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

final class BinaryTreePaths {
    private BinaryTreePaths() {

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        final List<String> res = new ArrayList<>();
        binaryTreePathsRec(root, "", res);
        return res;
    }

    private static void binaryTreePathsRec(TreeNode root, String s, List<String> res) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                res.add(s + root.val);
            } else {
                binaryTreePathsRec(root.left, s + root.val, res);
                binaryTreePathsRec(root.right, s + root.val, res);
            }
        }
    }
}
