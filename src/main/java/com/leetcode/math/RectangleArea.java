package com.leetcode.math;

public final class RectangleArea {
    private RectangleArea() {

    }

    @SuppressWarnings( {"checkstyle:ParameterNumber", "squid:S107"})
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        Range aXRange = Range.of(ax1, ax2);
        Range bXRange = Range.of(bx1, bx2);
        Range xIntersection = aXRange.intersection(bXRange);
        Range aYRange = Range.of(ay1, ay2);
        Range bYRange = Range.of(by1, by2);
        Range yIntersection = aYRange.intersection(bYRange);
        final int sumArea = aXRange.length() * aYRange.length() + bXRange.length() * bYRange.length();
        if (xIntersection == null || yIntersection == null) {
            return sumArea;
        }
        return sumArea - xIntersection.length() * yIntersection.length();
    }

    static final class Range {
        private final int a;
        private final int b;

        private Range(int a, int b) {
            this.a = a;
            this.b = b;
        }

        private static boolean isBetween(int start, int end, int point) {
            return point >= start && point <= end;
        }

        static Range of(int a, int b) {
            return new Range(a, b);
        }

        int length() {
            return b - a;
        }

        Range copy() {
            return of(a, b);
        }

        Range intersection(Range range) {
            boolean isLeftInside = isInside(range.a);
            boolean isRightInside = isInside(range.b);
            if (isLeftInside && isRightInside) {
                return range.copy();
            } else {
                if (isLeftInside) {
                    return of(range.a, b);
                } else {
                    if (isRightInside) {
                        return of(a, range.b);
                    } else {
                        if (range.isInside(a) && range.isInside(b)) {
                            return copy();
                        }
                        return null;
                    }
                }
            }
        }

        boolean isInside(int p) {
            return isBetween(a, b, p);
        }
    }
}
