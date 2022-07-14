package com.leetcode.tree;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
final class ConstructBinaryTree {
    private ConstructBinaryTree() {
        //Utility class
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRec(preorder, inorder, 0, preorder.length - 1, 0);
    }

    private static TreeNode buildTreeRec(int[] preorder, int[] inorder, int left, int right, int index) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == preorder[index]) {
                TreeNode leftNode = buildTreeRec(preorder, inorder, left, i - 1, index + 1);
                TreeNode rightNode = buildTreeRec(preorder, inorder, i + 1, right, index + (i - left) + 1);
                return new TreeNode(inorder[i], leftNode, rightNode);
            }
        }
        return null;
    }
}
