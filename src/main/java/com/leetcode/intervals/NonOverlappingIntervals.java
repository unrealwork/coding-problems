package com.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

public final class NonOverlappingIntervals {
    private NonOverlappingIntervals() {
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int removed = 0;
        int[] lastInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            boolean isOverlapping = curInterval[0] < lastInterval[1];
            if (isOverlapping) {
                removed++;
                if (curInterval[1] < lastInterval[1]) {
                    lastInterval = curInterval;
                }
            } else {
                lastInterval = curInterval;
            }
        }
        return removed;
    }
}
