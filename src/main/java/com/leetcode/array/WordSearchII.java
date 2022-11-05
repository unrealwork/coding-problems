package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public final class WordSearchII {
    private WordSearchII() {
    }

    // TODO: TLE
    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!visited[i][j]) {
                    fillTrie(trie, board, i, j, visited);
                    visited[i][j] = true;
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (trie.search(word)) {
                list.add(word);
            }
        }
        return list;
    }

    private static void fillTrie(Trie trie, char[][] board, int i, int j, boolean[][] visited) {
        Deque<WordPath> queue = new LinkedList<>();
        queue.add(WordPath.symbolPath(board, i, j));
        while (!queue.isEmpty()) {
            WordPath currentPath = queue.remove();
            trie.insert(currentPath.currentWord);
            List<WordPath> nextPaths = currentPath.nextPaths();
            for (WordPath nextPath : nextPaths) {
                queue.add(nextPath);
                int[] lastCoordinates = nextPath.path[nextPath.length - 1];
                if (!visited[lastCoordinates[0]][lastCoordinates[1]]) {
                    queue.add(WordPath.symbolPath(board, lastCoordinates[0], lastCoordinates[1]));
                    visited[lastCoordinates[0]][lastCoordinates[1]] = true;
                }
            }
        }
    }


    private static final class WordPath {
        private static final int MAX_LENGTH = 10;
        private final char[][] board;
        private final int[][] path = new int[MAX_LENGTH][2];
        private int length = 0;
        private String currentWord = "";

        private WordPath(char[][] board) {
            this.board = board;
        }

        private static WordPath symbolPath(char[][] board, int i, int j) {
            final WordPath wordPath = new WordPath(board);
            return wordPath.addSymbol(i, j);
        }

        public boolean isNewSymbol(int i, int j) {
            for (int symbolIndex = 0; symbolIndex < length; symbolIndex++) {
                if (path[symbolIndex][0] == i && path[symbolIndex][1] == j) {
                    return false;
                }
            }
            return true;
        }

        public WordPath addSymbol(int i, int j) {
            if (isMaxLengthPath()) {
                throw new IllegalStateException();
            }
            WordPath wordPath = new WordPath(board);
            wordPath.length = length + 1;
            for (int symbolIndex = 0; symbolIndex < length; symbolIndex++) {
                wordPath.path[symbolIndex][0] = path[symbolIndex][0];
                wordPath.path[symbolIndex][1] = path[symbolIndex][1];
            }
            wordPath.path[length][0] = i;
            wordPath.path[length][1] = j;
            wordPath.currentWord = currentWord + board[i][j];
            return wordPath;
        }

        boolean isMaxLengthPath() {
            return length == MAX_LENGTH;
        }

        private List<WordPath> nextPaths() {
            if (isMaxLengthPath()) {
                return Collections.emptyList();
            }
            int lastI = path[length - 1][0];
            int lastJ = path[length - 1][1];
            List<WordPath> res = new ArrayList<>();
            if (lastI > 0 && isNewSymbol(lastI - 1, lastJ)) {
                res.add(addSymbol(lastI - 1, lastJ));
            }

            if (lastI < board.length - 1 && isNewSymbol(lastI + 1, lastJ)) {
                res.add(addSymbol(lastI + 1, lastJ));
            }

            if (lastJ > 0 && isNewSymbol(lastI, lastJ - 1)) {
                res.add(addSymbol(lastI, lastJ - 1));
            }

            if (lastJ < board[lastI].length - 1 && isNewSymbol(lastI, lastJ + 1)) {
                res.add(addSymbol(lastI, lastJ + 1));
            }
            return res;
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
            parent.setTerminal(true);
        }

        public boolean search(String word) {
            TrieNode prefixNode = prefixNode(word);
            return prefixNode != null && prefixNode.isTerminal();
        }

        private TrieNode prefixNode(String prefix) {
            TrieNode it = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                TrieNode child = it.getChild(c);
                if (child == null) {
                    return child;
                }
                it = child;
            }
            return it;
        }

        private final class TrieNode {
            private final TrieNode[] nodes;
            private boolean isTerminal;

            private TrieNode() {
                this.nodes = new TrieNode['z' - 'a' + 1];
            }

            void addChild(char c, TrieNode node) {
                nodes[c - 'a'] = node;
            }

            TrieNode getChild(char c) {
                return nodes[c - 'a'];
            }

            boolean isTerminal() {
                return isTerminal;
            }

            public void setTerminal(boolean terminal) {
                isTerminal = terminal;
            }

            boolean hasChild(char c) {
                return getChild(c) != null;
            }
        }
    }
}
