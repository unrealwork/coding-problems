package com.leetcode.backtracking;

public final class WordSearch {
    private WordSearch() {
    }

    public static boolean exist(char[][] board, String word) {
        return new Solver(board, word).solve();
    }

    private static final class Solver {
        private static final int[][] DIST = new int[][] {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        private final char[][] board;
        private final String word;
        private final int m;
        private final int n;

        private Solver(char[][] board, String word) {
            this.board = board;
            this.word = word;
            this.m = board.length;
            n = board[0].length;
        }

        boolean solve() {
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (solve(0, i, j, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean solve(int wordIndex, int i, int j, boolean[][] visited) {
            if (board[i][j] != word.charAt(wordIndex)) {
                return false;
            }
            if (wordIndex + 1 == word.length()) {
                return true;
            }
            visited[i][j] = true;
            for (int[] d : DIST) {
                int adjI = i + d[0];
                int adjJ = j + d[1];
                int nextWordIndex = wordIndex + 1;
                if (isValid(adjI, adjJ) && !visited[adjI][adjJ]) {
                    if (solve(nextWordIndex, adjI, adjJ, visited)) {
                        return true;
                    } else {
                        visited[adjI][adjJ] = false;
                    }
                }
                visited[i][j] = false;
            }
            return false;
        }

        private boolean isValid(int i, int j) {
            return i > -1 && i < m && j > -1 && j < n;
        }
    }
}
