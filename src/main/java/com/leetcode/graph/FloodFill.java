package com.leetcode.graph;

final class FloodFill {
    private FloodFill() {
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Image img = Image.fromArray(image);
        FloodFiller floodFiller = new FloodFiller(img, sr, sc, newColor);
        floodFiller.flood();
        return img.img;
    }

    private static class FloodFiller {
        private final Image image;
        private final boolean[][] visited;
        private final int r;
        private final int c;
        private final int color;
        private final int newColor;

        FloodFiller(Image image, int row, int column, int newColorValue) {
            this.image = image;
            this.visited = new boolean[image.img.length][];
            this.r = row;
            this.c = column;
            this.color = image.getColor(row, column);
            this.newColor = newColorValue;
        }

        void flood() {
            flood(r, c);
        }

        private void flood(int row, int column) {
            if (image.isValid(row, column)) {
                if (visited[row] == null) {
                    visited[row] = new boolean[image.img[row].length];
                }
                if (!visited[row][column]) {
                    visited[row][column] = true;
                    if (image.getColor(row, column) == color) {
                        image.setColor(row, column, newColor);
                        flood(row + 1, column);
                        flood(row - 1, column);
                        flood(row, column + 1);
                        flood(row, column - 1);
                    }
                }
            }
        }
    }

    private static final class Image {
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
    }

}
