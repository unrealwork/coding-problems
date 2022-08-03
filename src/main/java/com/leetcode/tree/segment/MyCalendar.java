package com.leetcode.tree.segment;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

class MyCalendar {

    private final TreeSet<Event> set = new TreeSet<>(Comparator.comparing(e -> e.start));

    public boolean book(int start, int end) {
        Event newEvent = new Event(start, end);
        Event after = set.ceiling(newEvent);
        Event before = set.floor(newEvent);

        final boolean canBeAdded;
        if (before == null && after == null) {
            canBeAdded = true;
        } else {
            if (before == null) {
                canBeAdded = newEvent.end <= after.start;
            } else {
                if (after == null) {
                    canBeAdded = newEvent.start >= before.end;
                } else {
                    canBeAdded = newEvent.start >= before.end && newEvent.end <= after.start;
                }
            }
        }
        if (canBeAdded) {
            set.add(newEvent);
        }
        return canBeAdded;
    }

    static final class Event {
        private final int start;
        private final int end;

        private Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Event event = (Event) o;
            return start == event.start && end == event.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}
