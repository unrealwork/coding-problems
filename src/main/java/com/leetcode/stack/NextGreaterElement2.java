package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class NextGreaterElement2 {
    private NextGreaterElement2() {
    }

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) {
                deque.addLast(i);
            } else {
                if (nums[i] <= nums[deque.peekLast()]) {
                    deque.addLast(i);
                } else {
                    while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                        int lessIndex = deque.removeLast();
                        res[lessIndex] = nums[i];
                    }
                    deque.addLast(i);
                }
            }
        }
        hadnleUncovered(nums, deque, res);
        return res;
    }

    private static void hadnleUncovered(int[] nums, Deque<Integer> deque, int[] res) {
        int i = 0;

        while (!deque.isEmpty()) {
            while (i < deque.peekLast() && nums[i] <= nums[deque.peekLast()]) {
                i++;
            }
            if (nums[i] == nums[deque.peekLast()]) {
                res[deque.removeLast()] = -1;
            } else {
                res[deque.removeLast()] = nums[i];
            }
        }
    }

}
