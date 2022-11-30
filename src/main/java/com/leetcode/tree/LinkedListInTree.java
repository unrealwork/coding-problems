package com.leetcode.tree;

import com.leetcode.list.ListNode;

public final class LinkedListInTree {
    private LinkedListInTree() {
    }


    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (root != null) {
            if (isSubPathRec(head, root)) {
                return true;
            } else {
                return isSubPath(head, root.left) || isSubPath(head, root.right);
            }
        }
        return false;
    }

    private static boolean isSubPathRec(ListNode it, TreeNode curNode) {
        if (it == null) {
            return true;
        }
        if (curNode == null) {
            return false;
        }
        if (curNode.val != it.val) {
            return false;
        }
        return isSubPathRec(it.next, curNode.left) || isSubPathRec(it.next, curNode.right);
    }
}
