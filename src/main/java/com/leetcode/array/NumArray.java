package com.leetcode.array;

public final class NumArray {

    private final SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    void update(SegmentTreeNode node, int pos, int val) {
        if (node.start == node.end) {
            node.sum = val;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (pos <= mid) {
                update(node.left, pos, val);
            } else {
                update(node.right, pos, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode node, int start, int end) {
        if (node.end == end && node.start == start) {
            return node.sum;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (end <= mid) {
                return sumRange(node.left, start, end);
            } else if (start >= mid + 1) {
                return sumRange(node.right, start, end);
            } else {
                return sumRange(node.right, mid + 1, end) + sumRange(node.left, start, mid);
            }
        }
    }

    static final class SegmentTreeNode {
        private int start;
        private int end;
        private SegmentTreeNode left;
        private SegmentTreeNode right;
        private int sum;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
}
