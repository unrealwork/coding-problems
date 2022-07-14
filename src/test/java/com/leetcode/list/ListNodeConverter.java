package com.leetcode.list;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;

public class ListNodeConverter implements ArgumentConverter {
    private static ListNode intsToList(int... nums) {
        ListNode it = null;
        ListNode head = null;
        for (int n : nums) {
            if (head == null) {
                head = new ListNode(n);
                it = head;
            } else {
                final ListNode newNode = new ListNode(n);
                it.next = newNode;
                it = newNode;
            }
        }
        return head;
    }


    @Override
    public final Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        final String strList = (String) source;
        if (strList.trim().isEmpty()) {
            return null;
        }
        final int[] nums = Arrays.stream(strList.split(",\\s*"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return intsToList(nums);
    }
}
