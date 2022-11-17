package com.leetcode.string;

public final class OneSwapEqual {
    private OneSwapEqual() {
    }

    @SuppressWarnings("squid:S3776")
    public static boolean areAlmostEqual(String s1, String s2) {
        int i = 0;
        int j = s1.length() - 1;
        int swappedElement = 0;
        while (i <= j) {
            char leftS1 = s1.charAt(i);
            char leftS2 = s2.charAt(i);
            char rightS1 = s1.charAt(j);
            char rightS2 = s2.charAt(j);
            if (leftS1 != leftS2 && rightS1 != rightS2) {
                if (leftS1 == rightS2 && rightS1 == leftS2) {
                    i++;
                    j--;
                    swappedElement++;
                } else {
                    return false;
                }
            }
            if (leftS1 == leftS2) {
                i++;
            }
            if (rightS1 == rightS2) {
                j--;
            }
            if (swappedElement > 1) {
                return false;
            }
        }
        if (s1.length() == 1) {
            return true;
        }
        return swappedElement != 0 || s1.charAt(i) == s2.charAt(i);
    }
}
