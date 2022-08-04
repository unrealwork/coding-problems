package com.leetcode.math;

final class MirrorReflection {
    private MirrorReflection() {
    }

    static int mirrorReflection(int p, int q) {
        boolean isRightSide = true;
        int cur = q;
        boolean isAddition = true;
        while (cur != 0 && cur != p) {
            if (isAddition) {
                cur += q;
            } else {
                cur -= q;
            }
            if (cur > p) {
                isAddition = false;
                cur = p - (cur - p);
            }
            if (cur < 0) {
                isAddition = true;
                cur = -cur;
            }
            isRightSide = !isRightSide;
        }

        if (isRightSide) {
            if (cur == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        return 2;
    }
}
