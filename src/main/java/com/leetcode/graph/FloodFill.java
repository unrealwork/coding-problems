package com.leetcode.graph;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Image img = Image.fromArray(image);
        img.flood(sr, sc, newColor);
        return img.img;
    }

    private static class Image {
        private Image(int[][] img) {
            this.img = img;
        }

        private final int[][] img;

        public static Image fromArray(int[][] img) {
            return new Image(img);
        }

        public int getColor(int r, int c) {
            return img[r][c];
        }

        public void setColor(int r, int c, int color) {
            this.img[r][c] = color;
        }

        public boolean isValid(int r, int c) {
            return r >= 0 && r < img.length && c >= 0 && c < img[r].length;
        }

        void flood(int r, int c, int newColor) {
            flood(r, c, newColor, new boolean[img.length][]);
        }

        private void flood(int r, int c, int newColor, boolean[][] visited) {
            if (isValid(r, c)) {
                if (visited[r] == null) {
                    visited[r] = new boolean[img[r].length];
                }
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    if (getColor(r, c) == 1) {
                        setColor(r, c, newColor);
                        flood(r + 1, c, newColor, visited);
                        flood(r - 1, c, newColor, visited);
                        flood(r, c + 1, newColor, visited);
                        flood(r, c - 1, newColor, visited);
                    }
                }
            }
        }
    }

}
