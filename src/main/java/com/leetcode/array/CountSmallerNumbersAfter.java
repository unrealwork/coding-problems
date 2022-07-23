package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

final class CountSmallerNumbersAfter {
    private CountSmallerNumbersAfter() {
    }

    public static List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> sortedList = new ArrayList<>(nums.length);
        int start = nums.length - 1;
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = start; i > -1; i--) {
            int index = Collections.binarySearch(sortedList, nums[i] - 1);
            if (index > -1) {
                int newIndex = index + 1;
                while (newIndex < sortedList.size() && sortedList.get(newIndex) < nums[i]) {
                    newIndex++;
                }
                res.addFirst(index + 1);
                sortedList.add(newIndex, nums[i]);
            } else {
                int newIndex = -index - 1;
                res.addFirst(newIndex);
                sortedList.add(newIndex, nums[i]);
            }
        }
        return res;
    }
}
