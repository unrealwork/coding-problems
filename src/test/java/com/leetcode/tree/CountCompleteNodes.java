package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public final class CountCompleteNodes {
    private static final Map<Integer, Integer> POWER2_MEMO = new HashMap<>();

    private CountCompleteNodes() {

    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftLeftDepth = depth(root.left, true);
            int leftRightDepth = depth(root.left, false);
            int rightRightDepth = depth(root.right, false);
            if (leftLeftDepth == rightRightDepth) {
                return countFullTreeNodes(leftLeftDepth + 1);
            }
            if (leftLeftDepth == leftRightDepth) {
                return 1 + countFullTreeNodes(leftLeftDepth) + countNodes(root.right);
            } else {
                return 1 + countFullTreeNodes(rightRightDepth) + countNodes(root.left);
            }

        }
    }

    private static int countFullTreeNodes(int depth) {
        if (POWER2_MEMO.containsKey(depth)) {
            return POWER2_MEMO.get(depth);
        } else {
            int res = 0;
            int levelNodes = 1;
            for (int i = 0; i < depth; i++) {
                res += levelNodes;
                levelNodes *= 2;
            }
            POWER2_MEMO.put(depth, res);
            return res;
        }
    }

    private static int depth(final TreeNode node, boolean isLeft) {
        TreeNode it = node;
        int res = 0;
        while (it != null) {
            if (isLeft) {
                it = it.left;
            } else {
                it = it.right;
            }
            res++;
        }
        return res;
    }
}
