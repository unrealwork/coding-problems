package com.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

final class Codec {

    private static Integer parseNullableInteger(final String numStr) {
        if (Objects.equals(numStr, "null")) {
            return null;
        }
        return Integer.parseInt(numStr);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder("[");
        if (root != null) {
            deque.addFirst(root);
            sb.append(root.val);
        }
        while (!deque.isEmpty()) {
            int k = deque.size();
            sb.append(',');
            for (int i = 0; i < k; i++) {
                TreeNode node = deque.removeLast();
                if (node.left != null) {
                    deque.addFirst(node.left);
                    sb.append(node.left.val).append(',');
                } else {
                    sb.append("null,");
                }
                if (node.right != null) {
                    deque.addFirst(node.right);
                    sb.append(node.right.val);
                } else {
                    sb.append("null");
                }
                if (i != k - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.append(']').toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String strList = data.substring(1, data.length() - 1);
        if (strList.isEmpty()) {
            return null;
        }
        LinkedList<Integer> values = Arrays.stream(strList.split(",\\s*"))
                .map(Codec::parseNullableInteger)
                .collect(Collectors.toCollection(LinkedList::new));
        if (values.isEmpty()) {
            return null;
        }

        LinkedList<TreeNode> lastLevel = new LinkedList<>();
        TreeNode root = new TreeNode(values.removeFirst());
        lastLevel.add(root);
        while (!values.isEmpty()) {
            handleLevel(values, lastLevel);
        }
        return root;
    }

    private void handleLevel(LinkedList<Integer> values, LinkedList<TreeNode> lastLevel) {
        int k = lastLevel.size();
        for (int i = 0; i < k; i++) {
            TreeNode node = lastLevel.removeFirst();
            if (!values.isEmpty()) {
                Integer left = values.removeFirst();
                Integer right = null;
                if (!values.isEmpty()) {
                    right = values.removeFirst();
                }
                if (left != null) {
                    node.left = new TreeNode(left);
                    lastLevel.addLast(node.left);
                }
                if (right != null) {
                    node.right = new TreeNode(right);
                    lastLevel.addLast(node.right);
                }
            }
        }
    }
}
