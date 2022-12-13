package com.leetcode.hashmap;

public final class TaskScheduler {
    private static final int ALPHABET_SIZE = 26;

    private TaskScheduler() {
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] cooldown = new int[ALPHABET_SIZE];
        int[] leftTasks = countDict(tasks);
        int leftTasksCount = tasks.length;
        int passedTime = 0;
        while (leftTasksCount > 0) {
            int next = nextTask(leftTasks, cooldown);
            for (int i = 0; i < cooldown.length; i++) {
                if (cooldown[i] > 0) {
                    cooldown[i]--;
                }
            }
            if (next != -1) {
                leftTasksCount--;
                cooldown[next] = n;
                leftTasks[next]--;
            }
            passedTime++;
        }
        return passedTime;
    }


    private static int nextTask(int[] leftTasks, int[] cooldown) {
        int next = -1;
        for (int i = 0; i < leftTasks.length; i++) {
            if (leftTasks[i] > 0 && cooldown[i] == 0 && (next == -1 || leftTasks[i] > leftTasks[next])) {
                next = i;
            }
        }
        return next;
    }

    private static int[] countDict(char[] chars) {
        int[] dict = new int[ALPHABET_SIZE];
        for (char c : chars) {
            dict[c - 'A']++;
        }
        return dict;
    }
}
