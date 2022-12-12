package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class NextGreaterElement2 {
    private NextGreaterElement2() {
    }

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = monotonicStack(nums);
        int[] res = new int[nums.length];
        int i = 0;
        while (!deque.isEmpty()) {
            if (i == deque.peekFirst()) {
                deque.removeFirst();
            }
            if (!deque.isEmpty()) {
                res[i] = nums[deque.peekFirst()];
            } else {
                res[i] = -1;
            }
            i++;
        }
        if (i == 0) {
            res[i] = -1;
            i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > nums[nums.length - 1]) {
                deque.addLast(j);
                break;
            }
        }
        for (int j = i; j < nums.length; j++) {
            if (deque.isEmpty()) {
                res[j] = -1;
            } else {
                res[j] = nums[deque.peekLast()];
            }
        }
        return res;
    }

    private static Deque<Integer> monotonicStack(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty() || nums[i] > nums[deque.peekLast()]) {
                deque.addLast(i);
            }
        }
        deque.removeFirst();
        return deque;
    }
}
