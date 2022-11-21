package com.leetcode.graph;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/">Nearest Exit from Entrance in Maze</a>
 */
public final class NearestExit {
    private NearestExit() {
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        return new Solver(maze).solve(entrance);
    }

    private static final class Solver {
        private final char[][] maze;
        private final int m;
        private final int n;
        private final int[][] shifts = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        private Solver(char[][] maze) {
            this.maze = maze;
            this.m = maze.length;
            this.n = maze[0].length;
        }

        @SuppressWarnings("squid:S3776")
        int solve(int[] entrance) {
            Deque<Integer> deque = new ArrayDeque<>();
            boolean[][] visited = new boolean[m][n];
            deque.addFirst(entrance[0]);
            deque.addFirst(entrance[1]);
            int dist = 0;
            while (!deque.isEmpty()) {
                int cellSize = deque.size() / 2;
                dist++;
                for (int k = 0; k < cellSize; k++) {
                    int curI = deque.removeLast();
                    int curJ = deque.removeLast();
                    visited[curI][curJ] = true;
                    for (int[] shift : shifts) {
                        final int i = curI + shift[0];
                        final int j = curJ + shift[1];
                        if (isValid(i, j) && !visited[i][j] && isEmpty(i, j)) {
                            deque.addFirst(i);
                            deque.addFirst(j);
                            if (isEdge(i, j)) {
                                return dist;
                            }
                            visited[i][j] = true;
                        }
                    }
                }
            }
            return -1;
        }

        private boolean isValid(int i, int j) {
            return i > -1 && i < m && j > -1 && j < n;
        }

        private boolean isEmpty(int i, int j) {
            return maze[i][j] == '.';
        }

        private boolean isEdge(int i, int j) {
            return i == 0 || i == m - 1 || j == 0 || j == n - 1;
        }
    }
}
