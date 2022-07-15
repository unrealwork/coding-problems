package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;

final class MaxAreaOfIsland {
    private static final char LAND = 1;

    private MaxAreaOfIsland() {

    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] covered = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                boolean isLand = grid[i][j] == LAND;
                if (!covered[i][j] && isLand) {
                    maxArea = Math.max(areaOfIsland(i, j, grid, covered), maxArea);
                }
            }
        }
        return maxArea;
    }

    private static int areaOfIsland(int i, int j, int[][] grid, boolean[][] covered) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[] {i, j});
        int area = 0;
        while (!stack.isEmpty()) {
            int[] lastCell = stack.removeLast();
            int curI = lastCell[0];
            int curJ = lastCell[1];
            boolean isValid = isValidCell(grid, curI, curJ);
            if (isValid && !covered[curI][curJ]) {
                covered[curI][curJ] = true;
                if (grid[curI][curJ] == LAND) {
                    addNeighbors(stack, curI, curJ);
                    area++;
                }
            }
        }
        return area;
    }

    private static boolean isValidCell(int[][] grid, int curI, int curJ) {
        return curI > -1 && curI < grid.length && curJ > -1 && curJ < grid[0].length;
    }

    private static void addNeighbors(Deque<int[]> next, int curI, int curJ) {
        next.addLast(new int[] {curI + 1, curJ});
        next.addLast(new int[] {curI, curJ + 1});
        next.addLast(new int[] {curI - 1, curJ});
        next.addLast(new int[] {curI, curJ - 1});
    }
}
