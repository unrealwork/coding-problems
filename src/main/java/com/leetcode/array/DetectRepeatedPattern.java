package com.leetcode.array;

final class DetectRepeatedPattern {
    private DetectRepeatedPattern() {

    }

    public static boolean containsPattern(int[] arr, int patternLen, int repeatTimes) {
        int seqLen = patternLen * repeatTimes;
        if (seqLen > arr.length) {
            return false;
        }
        for (int i = 0; i <= arr.length - seqLen; i++) {
            if (isRepeatedPattern(arr, patternLen, seqLen, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRepeatedPattern(int[] arr, int patternLen, int seqLen, int seqStart) {
        for (int i = seqStart + patternLen; i < seqStart + seqLen; i += patternLen) {
            for (int j = i; j < i + patternLen; j++) {
                if (arr[j] != arr[j - patternLen]) {
                    return false;
                }
            }
        }
        return true;
    }
}
