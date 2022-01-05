package com.leetcode.list;

public class IntersectionTwoLists {
    private IntersectionTwoLists() {
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = size(headA);
        int sizeB = size(headB);
        if (sizeA > sizeB) {
            int diff = sizeA - sizeB;
            ListNode aDiffthNode = skip(headA, diff);
            return sameSizeIntersection(aDiffthNode, headB);
        } else {
            return sameSizeIntersection(headA, skip(headB, sizeB - sizeA));
        }
    }

    private static ListNode skip(ListNode head, int diff) {
        ListNode it = head;
        int skipped = 0;
        while (skipped < diff) {
            if (it == null) {
                throw new IllegalStateException("Unable to skip " + diff + " nodes");
            }
            skipped++;
            it = it.next;
        }
        return it;
    }

    private static int size(ListNode head) {
        int size = 0;
        ListNode it = head;
        while (it != null) {
            size++;
            it = it.next;
        }
        return size;
    }

    private static ListNode sameSizeIntersection(ListNode headA, ListNode headB) {
        ListNode itA = headA;
        ListNode itB = headB;
        while (itA != null) {
            if (itA == itB) {
                return itA;
            }
            itA = itA.next;
            if (itB == null) {
                throw new IllegalStateException("Provided lists should be with the same size");
            }
            itB = itB.next;
        }
        return null;
    }
}
