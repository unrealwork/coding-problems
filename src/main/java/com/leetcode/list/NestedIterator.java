package com.leetcode.list;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public final class NestedIterator implements Iterator<Integer> {
    private final Deque<NestedInteger> next = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger integer : nestedList) {
            if (integer.isInteger() || !integer.getList().isEmpty()) {
                next.addFirst(integer);
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return next.removeLast().getInteger();
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNext() {
        while (!next.isEmpty() && !next.peekLast().isInteger()) {
            NestedInteger integer = next.removeLast();
            List<NestedInteger> list = integer.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                NestedInteger ni = list.get(i);
                if (ni.isInteger() || !ni.getList().isEmpty()) {
                    next.addLast(ni);
                }
            }
        }
        return !next.isEmpty();
    }

    interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }
}
