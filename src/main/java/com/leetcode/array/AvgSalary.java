package com.leetcode.array;

public class AvgSalary {
    private AvgSalary() {
    }

    public static double average(int[] salary) {
        int min = min(salary);
        int max = max(salary);
        double sum = 0;
        int count = 0;
        for (int s : salary) {
            if (s != min && s != max) {
                sum += s;
                count++;
            }
        }

        return (count > 0) ? sum / count : Double.NaN;
    }

    private static int min(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private static int max(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
