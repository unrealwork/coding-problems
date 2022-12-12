package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public final class TrappingRainWater {
    private TrappingRainWater() {
    }

    public static int trap(int[] height) {
        Deque<Integer> decreasingStack = new ArrayDeque<>();

        int currentContainer = 0;

        for (int i = 0; i < height.length; i++) {
            int curHeight = height[i];
            while (!decreasingStack.isEmpty() && height[decreasingStack.peekLast()] <= curHeight) {
                int leftBlocking = decreasingStack.removeLast();
                if (decreasingStack.isEmpty()) {
                    break;
                }
                int addedHeight = Math.min(height[decreasingStack.peekLast()], curHeight) - height[leftBlocking];
                int addedWidth = i - decreasingStack.peekLast() - 1;
                currentContainer += addedHeight * addedWidth;
            }
            if (decreasingStack.isEmpty() || height[decreasingStack.peek()] > curHeight) {
                decreasingStack.addLast(i);
            }
        }
        return currentContainer;
    }
}
