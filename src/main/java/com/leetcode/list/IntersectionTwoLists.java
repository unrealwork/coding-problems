package com.leetcode.list;

/**
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a>
 */
@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
public final class IntersectionTwoLists {
    private IntersectionTwoLists() {
    }

    /**
     * Tail intersection of two linked lists.
     *
     * @param headA head of first list.
     * @param headB head of second list.
     * @return head of intersection part.
     */
    public static ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
        final int sizeA = size(headA);
        final int sizeB = size(headB);
        return sizeA > sizeB ?
                sameSizeIntersection(skip(headA, sizeA - sizeB), headB)
                : sameSizeIntersection(headA, skip(headB, sizeB - sizeA));
    }

    private static ListNode skip(final ListNode head, final int diff) {
        ListNode iterator = head;
        int skipped = 0;
        while (skipped < diff) {
            if (iterator == null) {
                throw new IllegalStateException("Unable to skip " + diff + " nodes");
            }
            skipped++;
            iterator = iterator.next;
        }
        return iterator;
    }

    private static int size(final ListNode head) {
        int size = 0;
        ListNode iterator = head;
        while (iterator != null) {
            size++;
            iterator = iterator.next;
        }
        return size;
    }

    @SuppressWarnings("PMD.CompareObjectsWithEquals")
    private static ListNode sameSizeIntersection(final ListNode headA, final ListNode headB) {
        ListNode itA = headA;
        ListNode itB = headB;
        ListNode intersection = null;
        while (itA != null) {
            if (itA == itB) {
                intersection = itA;
                break;
            }
            itA = itA.next;
            if (itB == null) {
                throw new IllegalStateException("Provided lists should be with the same size");
            }
            itB = itB.next;
        }
        return intersection;
    }
}
