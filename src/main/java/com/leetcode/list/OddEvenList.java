package com.leetcode.list;

public class OddEvenList {
    private OddEvenList() {
    }


    public static ListNode oddEvenList(ListNode head) {
        ListNode headOdd = null;
        ListNode headEven = null;
        ListNode tailOdd = null;
        ListNode tailEven = null;
        ListNode it = head;
        boolean isOdd = true;
        while (it != null) {
            if (isOdd) {
                if (headOdd == null) {
                    headOdd = new ListNode(it.val);
                    tailOdd = headOdd;
                } else {
                    tailOdd.next = new ListNode(it.val);
                    tailOdd = tailOdd.next;
                }
            } else {
                if (headEven == null) {
                    headEven = new ListNode(it.val);
                    tailEven = headEven;
                } else {
                    tailEven.next = new ListNode(it.val);
                    tailEven = tailEven.next;
                }
            }
            isOdd = !isOdd;
            it = it.next;
        }
        if (tailOdd != null) {
            tailOdd.next = headEven;
        }
        return headOdd;
    }
}
