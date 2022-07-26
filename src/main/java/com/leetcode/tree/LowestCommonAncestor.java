package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

final class LowestCommonAncestor {
    private LowestCommonAncestor() {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = parentMap(root);
        Deque<TreeNode> pathToP = path(p, parentMap);
        Deque<TreeNode> pathToQ = path(q, parentMap);
        TreeNode res = null;
        while (pathToP.peekFirst() == pathToQ.peekFirst()) {
            res = pathToP.removeFirst();
            pathToQ.removeFirst();
            if (pathToP.isEmpty() || pathToQ.isEmpty()) {
                break;
            }
        }
        return res;
    }


    private static Deque<TreeNode> path(TreeNode p, Map<TreeNode, TreeNode> parentMap) {
        Deque<TreeNode> path = new ArrayDeque<>();
        TreeNode it = p;
        while (it != null) {
            path.addFirst(it);
            it = parentMap.get(it);
        }
        return path;
    }

    private static Map<TreeNode, TreeNode> parentMap(TreeNode root) {
        HashMap<TreeNode, TreeNode> parentMap = new LinkedHashMap<>();
        parentMapRec(root, null, parentMap);
        return parentMap;
    }

    private static void parentMapRec(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (root != null) {
            parentMap.put(root, parent);
            parentMapRec(root.left, root, parentMap);
            parentMapRec(root.right, root, parentMap);
        }
    }

}
