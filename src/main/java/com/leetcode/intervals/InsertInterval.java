package com.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

final class InsertInterval {
    private InsertInterval() {
    }

    @SuppressWarnings("squid:S3012")
    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && !isOverlap(intervals[i], newInterval)) {
            res.add(intervals[i]);
            i++;
        }
        if (i == intervals.length) {
            if (intervals.length == 0) {
                res.add(newInterval);
            } else {
                int j = 0;
                while (j < intervals.length && intervals[j][0] < newInterval[0]) {
                    j++;
                }
                res.add(j, newInterval);
            }
        }

        if (i < intervals.length) {
            int[] mergedInterval = new int[2];
            mergedInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            mergedInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
            while (i < intervals.length && isOverlap(intervals[i], mergedInterval)) {
                mergedInterval[1] = Math.max(intervals[i][1], mergedInterval[1]);
                i++;
            }
            res.add(mergedInterval);
        }
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(int[][]::new);
    }

    private static boolean isOverlap(int[] i1, int[] i2) {
        if (i1[1] >= i2[0] && i1[1] <= i2[1]) {
            return true;
        }
        return i2[1] >= i1[0] && i2[1] <= i1[1];
    }
}

