package com.leetcode.tree;

import java.util.Objects;

final class DeleteBstNode {
    private DeleteBstNode() {
    }

    static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode it = root;
        while (it != null) {
            if (it.val == key) {
                break;
            }
            parent = it;
            if (it.left != null && it.val > key) {
                it = it.left;
            } else {
                it = it.right;
            }
        }
        if (it == null) {
            return root;
        }
        return removeNode(root, parent, it);
    }

    private static TreeNode removeNode(TreeNode root, TreeNode parent, TreeNode it) {

        if (it.left == null && it.right == null) {
            if (parent == null) {
                return null;
            }
            removeLeafNode(parent, it);
        } else {
            if (it.left != null && it.right != null) {
                removeNodeWithBothChildren(it, it.right);
            } else {
                if (parent == null) {
                    return Objects.requireNonNullElseGet(it.left, () -> it.right);
                }
                removeNodeWithOnlyChild(parent, it);
            }

        }
        return root;
    }

    private static void removeNodeWithBothChildren(TreeNode nodeToDelete, TreeNode rightChild) {
        TreeNode p = nodeToDelete;
        TreeNode it = rightChild;
        while (it.left != null) {
            p = it;
            it = it.left;
        }
        nodeToDelete.val = it.val;
        if (isLeaf(it)) {
            removeLeafNode(p, it);
        } else {
            removeNodeWithOnlyChild(p, it);
        }
    }

    private static void removeNodeWithOnlyChild(TreeNode parent, TreeNode it) {
        final TreeNode replacement;
        if (it.left != null) {
            replacement = it.left;
        } else {
            replacement = it.right;
        }
        if (parent.left == it) {
            parent.left = replacement;
        } else {
            parent.right = replacement;
        }
    }

    private static void removeLeafNode(TreeNode parent, TreeNode it) {
        if (parent.left == it) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    private static boolean isLeaf(TreeNode it) {
        return it.left == null && it.right == null;
    }
}
