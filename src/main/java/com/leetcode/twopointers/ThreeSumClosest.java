package com.leetcode.twopointers;

import java.util.Arrays;

public final class ThreeSumClosest {
    private ThreeSumClosest() {
    }

    @SuppressWarnings("squid:S3776")
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestDistance = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length; k++) {
            int i = 0;
            int j = nums.length - 1;
            while (j > i) {
                if (k != i && k != j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int dist = target - sum;
                    if (Math.abs(dist) < bestDistance) {
                        bestSum = sum;
                        bestDistance = Math.abs(dist);
                    }
                    if (dist > 0) {
                        i++;
                    } else {
                        j--;
                    }
                } else {
                    if (k == i) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return bestSum;
    }
}
