package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class PathSumII {
    private PathSumII() {
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pathSumRec(root, targetSum, 0, new LinkedList<>(), res);
        return res;
    }

    private static void pathSumRec(TreeNode node, int targetSum, int curSum,
                                   List<Integer> path, List<List<Integer>> res) {
        List<Integer> nextPath = new LinkedList<>(path);
        nextPath.add(node.val);
        if (node.left == null && node.right == null) {
            if (curSum + node.val == targetSum) {
                res.add(nextPath);
            }
        } else {
            if (node.left != null) {
                pathSumRec(node.left, targetSum, curSum + node.val, nextPath, res);
            }
            if (node.right != null) {
                pathSumRec(node.right, targetSum, curSum + node.val, nextPath, res);
            }
        }
    }
}
