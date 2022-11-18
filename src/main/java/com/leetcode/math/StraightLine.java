package com.leetcode.math;

import java.util.Arrays;
import java.util.Comparator;

public final class StraightLine {
    private StraightLine() {
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, Comparator.comparingInt(c -> c[0]));

        Angle d = angle(coordinates[0], coordinates[1]);
        for (int i = 2; i < coordinates.length; i++) {
            if (!d.isSame(angle(coordinates[i - 1], coordinates[i]))) {
                return false;
            }
        }
        return true;
    }

    private static Angle angle(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        return new Angle(dx, dy);
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == b) {
            return a;
        } else {
            if (a > b) {
                return gcd(a - b, b);
            } else {
                return gcd(a, b - a);
            }
        }
    }

    private static final class Angle {
        private final int dx;
        private final int dy;
        private final int gcd;

        private Angle(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
            this.gcd = gcd(Math.abs(dx), Math.abs(dy));
        }


        public boolean isSame(Angle angle) {
            if (dx == 0 || dy == 0 || angle.dx == 0 || angle.dy == 0) {
                return dx == 0 && angle.dx == 0 || dy == 0 && angle.dy == 0;
            }
            return dx / gcd == angle.dx / angle.gcd && dy / gcd == angle.dy / angle.gcd;
        }
    }
}
