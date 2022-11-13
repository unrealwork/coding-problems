package com.leetcode.stack;

import java.util.Objects;

public final class CrawlerLogFolder {
    private static final String BACK = "../";
    private static final String STAY = "./";

    private CrawlerLogFolder() {
    }

    public static int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (Objects.equals(log, BACK)) {
                if (res > 0) {
                    res--;
                }
            } else {
                if (!Objects.equals(log, STAY)) {
                    res++;
                }
            }
        }
        return res;
    }
}
