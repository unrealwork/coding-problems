package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;

public final class TwoSum4 {
    private TwoSum4() {
    }


    public static boolean findTarget(TreeNode root, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        preorder(root, val -> {
            map.computeIfPresent(val, (key, v) -> v + 1);
            map.computeIfAbsent(val, key -> 1);
        });
        for (Integer a : map.keySet()) {
            int b = target - a;
            if (map.containsKey(b) && (b != a || map.get(b) > 1)) {
                return true;
            }
        }
        return false;
    }

    private static void preorder(TreeNode root, IntConsumer intConsumer) {
        if (root != null) {
            preorder(root.left, intConsumer);
            intConsumer.accept(root.val);
            preorder(root.right, intConsumer);
        }
    }
}
