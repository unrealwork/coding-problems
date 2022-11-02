package com.leetcode.graph;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public final class MinimumGeneticMutation {
    private MinimumGeneticMutation() {

    }

    public static int minMutation(String start, String end, String[] bank) {
        Deque<String> queue = new LinkedList<>();
        queue.add(start);
        Map<String, Integer> distMap = new HashMap<>(bank.length + 1);
        distMap.put(start, 0);
        while (!queue.isEmpty()) {
            String currentGene = queue.remove();
            Integer curNodeDist = distMap.get(currentGene);
            for (String nextGene : bank) {
                if (!distMap.containsKey(nextGene) && isConnected(currentGene, nextGene)) {
                    int nextGeneDist = curNodeDist + 1;
                    distMap.put(nextGene, nextGeneDist);
                    if (Objects.equals(nextGene, end)) {
                        return nextGeneDist;
                    }
                    queue.add(nextGene);
                }
            }
        }
        return -1;
    }

    private static boolean isConnected(String start, String end) {
        int diffCount = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return true;
    }
}
