package com.leetcode.tree;

import util.ExcludeFromJacocoGeneratedReport;

import java.util.ArrayDeque;
import java.util.Deque;

@ExcludeFromJacocoGeneratedReport
public final class PopulatingRightPointer2 {
    private PopulatingRightPointer2() {

    }

    public static Node connect(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        if (root != null) {
            deque.addFirst(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                final Node node = deque.removeLast();
                if (i < size - 1) {
                    node.next = deque.peekLast();
                }
                if (node.left != null) {
                    deque.addFirst(node.left);
                }

                if (node.right != null) {
                    deque.addFirst(node.right);
                }
            }
        }
        return root;
    }
}
