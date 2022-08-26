package com.leetcode.math;

final class ReorderPowerOf2 {

    private static final byte BASE = 10;
    private static final int LIMIT = 1000000000;

    private ReorderPowerOf2() {
    }

    static boolean reorderedPowerOf2(int n) {
        byte[] dict = digitCount(n);
        int pow2 = 1;
        while (pow2 < LIMIT) {
            byte[] pow2Dict = digitCount(pow2);
            boolean isFound = true;
            for (byte i = 0; i < BASE; i++) {
                if (pow2Dict[i] != dict[i]) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                return true;
            }
            pow2 <<= 1;
        }
        return false;
    }

    private static byte[] digitCount(int n) {
        int rest = n;
        byte[] res = new byte[BASE];
        while (rest > 0) {
            byte digit = (byte) (rest % BASE);
            res[digit]++;
            rest /= BASE;
        }
        return res;
    }
}
