package com.leetcode.tree;

@SuppressWarnings("checkstyle:VisibilityModifier")
class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node() {
    }

    Node(int v) {
        val = v;
    }

    Node(int v, Node l, Node r, Node n) {
        val = v;
        left = l;
        right = r;
        next = n;
    }
}
