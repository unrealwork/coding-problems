package com.leetcode.tree;

import java.util.concurrent.atomic.AtomicInteger;

public final class SumOfRootToLeafNumbers {

    public static final int BASE = 10;

    private SumOfRootToLeafNumbers() {
    }

    public static int sumNumbers(TreeNode root) {
        AtomicInteger sum = new AtomicInteger();
        calcAllLeafNumbers(root, 0, sum);
        return sum.intValue();
    }

    private static void calcAllLeafNumbers(TreeNode currentNode, int parentNumber, AtomicInteger adder) {
        if (currentNode == null) {
            return;
        }
        int currentNumber = parentNumber * BASE + currentNode.val;
        if (currentNode.left == null && currentNode.right == null) {
            adder.addAndGet(currentNumber);
        } else {
            calcAllLeafNumbers(currentNode.left, currentNumber, adder);
            calcAllLeafNumbers(currentNode.right, currentNumber, adder);
        }
    }
}
