package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public final class ZigZagOrder {
    private ZigZagOrder() {
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.addFirst(root);
        }
        boolean isReversed = false;
        while (!deque.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int k = deque.size();
            for (int i = 0; i < k; i++) {
                TreeNode node = deque.removeLast();
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
                Integer el = node.val;
                if (isReversed) {
                    list.addFirst(el);
                } else {
                    list.addLast(el);
                }
            }
            isReversed = !isReversed;
            res.add(list);
        }
        return res;
    }
}
