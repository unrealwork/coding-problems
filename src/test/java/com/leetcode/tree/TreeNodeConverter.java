package com.leetcode.tree;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class TreeNodeConverter implements ArgumentConverter {
    @Override
    public final Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        final String strList = (String) source;
        if (strList.trim().isEmpty()) {
            return null;
        }
        LinkedList<Integer> values = Arrays.stream(strList.split(",\\s*"))
                .map(TreeNodeConverter::parseNullableInteger)
                .collect(Collectors.toCollection(LinkedList::new));
        if (values.isEmpty()) {
            return null;
        }

        LinkedList<TreeNode> lastLevel = new LinkedList<>();
        TreeNode root = new TreeNode(values.removeFirst());
        lastLevel.add(root);
        while (!values.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode node : lastLevel) {
                final TreeNode childLeft = nextNode(values);
                if (childLeft != null) {
                    nextLevel.add(childLeft);
                    node.left = childLeft;
                }
                final TreeNode childRight = nextNode(values);
                if (childRight != null) {
                    nextLevel.add(childRight);
                    node.right = childRight;
                }
            }
            lastLevel.clear();
            lastLevel = nextLevel;
        }
        return root;
    }

    private static TreeNode nextNode(final LinkedList<Integer> values) {
        if (!values.isEmpty()) {
            Integer val = values.removeFirst();
            if (val != null) {
                return new TreeNode(val);
            }
            return null;

        }
        return null;
    }

    private static Integer parseNullableInteger(final String numStr) {
        if (Objects.equals(numStr, "null")) {
            return null;
        }
        return Integer.parseInt(numStr);
    }
}
