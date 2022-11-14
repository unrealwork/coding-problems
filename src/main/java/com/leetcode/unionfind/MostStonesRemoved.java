package com.leetcode.unionfind;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class MostStonesRemoved {
    private MostStonesRemoved() {
    }

    public static int removeStones(int[][] stones) {
        Set<Union> unions = new HashSet<>();
        for (int[] stone : stones) {
            Set<Union> unionSet = unions.stream().filter(u -> u.contains(stone))
                    .collect(Collectors.toSet());
            if (unionSet.size() > 1) {
                Union union = new Union();
                unionSet.forEach(unions::remove);
                for (Union u : unionSet) {
                    union = union.union(u);
                }
                unions.add(union);
            } else {
                if (unionSet.size() == 1) {
                    unionSet.iterator().next().add(stone);
                } else {
                    unions.add(new Union(stone));
                }
            }
        }
        return stones.length - unions.size();
    }

    private static class Union {
        private final Set<Integer> rows = new HashSet<>();
        private final Set<Integer> columns = new HashSet<>();

        private int size;

        Union(int[] stone) {
            add(stone);
        }

        Union() {
        }

        boolean contains(int[] pos) {
            return rows.contains(pos[0]) || columns.contains(pos[1]);
        }

        void add(int[] pos) {
            rows.add(pos[0]);
            columns.add(pos[1]);
        }

        Union union(Union union) {
            Union u = new Union();
            u.rows.addAll(rows);
            u.columns.addAll(columns);
            u.rows.addAll(union.rows);
            u.columns.addAll(union.columns);
            u.size = size + union.size;
            return u;
        }
    }
}
