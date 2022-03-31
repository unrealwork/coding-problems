package com.leetcode.graph;

public class FloodFill {
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

        FloodFiller(Image image, int r, int c, int newColor) {
            this.image = image;
            this.visited = new boolean[image.img.length][];
            this.r = r;
            this.c = c;
            this.color = image.getColor(r, c);
            this.newColor = newColor;
        }

        void flood() {
            flood(r, c);
        }

        private void flood(int r, int c) {
            if (image.isValid(r, c)) {
                if (visited[r] == null) {
                    visited[r] = new boolean[image.img[r].length];
                }
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    if (image.getColor(r, c) == color) {
                        image.setColor(r, c, newColor);
                        flood(r + 1, c);
                        flood(r - 1, c);
                        flood(r, c + 1);
                        flood(r, c - 1);
                    }
                }
            }
        }
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
    }

}
