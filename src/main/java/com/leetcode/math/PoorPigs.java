package com.leetcode.math;

final class PoorPigs {
    private PoorPigs() {
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        double tests = minutesToTest / (double) minutesToDie;
        while (Math.pow(tests + 1, pigs) < buckets) {
            pigs += 1;
        }
        return pigs;
    }
}
