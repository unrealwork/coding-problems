package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public final class WordSearch2 {
    private WordSearch2() {
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return new Solver(board, trie.root).solve();
    }

    private static class Solver {
        private static final int[][] DIST = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        private final char[][] board;
        private final Trie.TrieNode trie;

        private final int m;
        private final int n;

        Solver(char[][] board, Trie.TrieNode trie) {
            this.board = board;
            this.trie = trie;
            this.m = board.length;
            this.n = board[0].length;
        }

        List<String> solve() {
            List<String> res = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char c = board[i][j];
                    if (trie.hasChild(c)) {
                        solve(trie.getChild(c), i, j, visited, res);
                    }
                }
            }
            return res;
        }

        private void solve(Trie.TrieNode trieNode, int i, int j, boolean[][] visited, List<String> res) {
            if (trieNode.isTerminal()) {
                res.add(trieNode.getWord());
                trieNode.markNonTermianl();
            }
            visited[i][j] = true;
            for (int[] d : DIST) {
                final int adjI = i + d[0];
                final int adjJ = j + d[1];
                if (isValid(adjI, adjJ) && !visited[adjI][adjJ]) {
                    char adjSym = board[adjI][adjJ];
                    if (trieNode.hasChild(adjSym)) {
                        solve(trieNode.getChild(adjSym), adjI, adjJ, visited, res);
                    }
                }
            }
            visited[i][j] = false;
        }

        private boolean isValid(int i, int j) {
            return i > -1 && i < m && j > -1 && j < n;
        }
    }

    private static class Trie {
        private final TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word.isEmpty()) {
                return;
            }
            TrieNode parent = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode current = parent.getChild(c);
                if (current != null) {
                    parent = current;
                } else {
                    TrieNode newNode = new TrieNode();
                    parent.addChild(c, newNode);
                    parent = newNode;
                }
            }
            parent.setWord(word);
        }

        private static final class TrieNode {
            private final TrieNode[] nodes;
            private String word;

            private TrieNode() {
                this.nodes = new TrieNode['z' - 'a' + 1];
            }

            void addChild(char c, TrieNode node) {
                nodes[c - 'a'] = node;
            }

            TrieNode getChild(char c) {
                return nodes[c - 'a'];
            }

            boolean hasChild(char c) {
                return getChild(c) != null;
            }

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }

            public boolean isTerminal() {
                return word != null;
            }

            public void markNonTermianl() {
                this.word = null;
            }
        }
    }
}
