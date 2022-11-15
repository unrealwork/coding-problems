package com.leetcode.array;

public final class NearestValidPoint {
    private NearestValidPoint() {
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int dist = Integer.MAX_VALUE;
            if (p[0] == x) {
                dist = Math.abs(p[1] - y);
            } else {
                if (p[1] == y) {
                    dist = Math.abs(p[0] - x);
                }
            }
            if (dist < minDist) {
                minDist = dist;
                index = i;
            }
        }
        return index;
    }
}
