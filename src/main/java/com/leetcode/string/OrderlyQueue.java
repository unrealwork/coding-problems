package com.leetcode.string;

import java.util.Arrays;

public final class OrderlyQueue {
    private OrderlyQueue() {

    }

    public static String orderlyQueue(String s, int k) {
        if (k == 1) {
            String best = s;
            String prev = s;
            for (int i = 0; i < s.length(); i++) {
                String cur = prev.substring(1) + prev.charAt(0);
                if (cur.compareTo(best) < 0) {
                    best = cur;
                }
                prev = cur;
            }
            return best;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
