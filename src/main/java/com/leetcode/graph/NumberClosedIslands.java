package com.leetcode.graph;

public final class NumberClosedIslands {
    private NumberClosedIslands() {
    }

    public static int closedIsland(int[][] grid) {
        return new Solver(grid).solve();
    }


    private static final class Solver {
        private final int[][] grid;
        private final boolean[][] explored;
        private final boolean[][] processing;

        private Solver(int[][] grid) {
            this.grid = grid;
            this.explored = new boolean[grid.length][grid[0].length];
            this.processing = new boolean[grid.length][grid[0].length];
        }

        public int solve() {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (!explored[i][j] && isClosed(i, j)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isEdge(int i, int j) {
            return !(i > 0 && j > 0 && i < grid.length - 1 && j < grid[0].length - 1);
        }

        private boolean isClosed(int i, int j) {
            explored[i][j] = true;
            if (isLand(i, j)) {
                processing[i][j] = true;
                boolean res = !isEdge(i, j)
                        && isValidAdjacent(i - 1, j)
                        && isValidAdjacent(i + 1, j)
                        && isValidAdjacent(i, j + 1)
                        && isValidAdjacent(i, j - 1);
                processing[i][j] = false;
                return res;
            }
            return false;
        }

        private boolean isValidAdjacent(int i, int j) {
            if (processing[i][j]) {
                return true;
            }
            return !isLand(i, j) || isClosed(i, j);
        }

        private boolean isLand(int i, int j) {
            return grid[i][j] == 0;
        }
    }
}
