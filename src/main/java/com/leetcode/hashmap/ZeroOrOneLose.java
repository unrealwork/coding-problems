package com.leetcode.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public final class ZeroOrOneLose {
    private static final int MAX_SIZE = 100001;

    private ZeroOrOneLose() {

    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        boolean[] seen = new boolean[MAX_SIZE];
        TreeSet<Integer> zeroLose = new TreeSet<>();
        TreeSet<Integer> oneLose = new TreeSet<>();
        for (int[] m : matches) {
            int winner = m[0];
            int loser = m[1];
            if (!seen[winner]) {
                zeroLose.add(winner);
            }
            if (!seen[loser]) {
                oneLose.add(loser);
            } else {
                if (!oneLose.remove(loser) && zeroLose.remove(loser)) {
                    oneLose.add(loser);
                }
            }
            seen[winner] = true;
            seen[loser] = true;
        }
        return Arrays.asList(new ArrayList<>(zeroLose), new ArrayList<>(oneLose));
    }
}
