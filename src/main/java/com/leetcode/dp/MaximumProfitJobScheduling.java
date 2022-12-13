package com.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public final class MaximumProfitJobScheduling {
    private static final int JOB_PARAM_SIZE = 3;

    private MaximumProfitJobScheduling() {
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][JOB_PARAM_SIZE];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[1]));

        TreeMap<Integer, Integer> endToTotalMap = new TreeMap<>();
        endToTotalMap.put(0, 0);
        for (int[] job : jobs) {
            int newValue = endToTotalMap.floorEntry(job[0]).getValue() + job[2];
            if (newValue > endToTotalMap.lastEntry().getValue()) {
                endToTotalMap.put(job[1], newValue);
            }
        }
        return endToTotalMap.lastEntry().getValue();
    }
}
