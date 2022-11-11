package com.leetcode.greedy;

public final class GasStation {
    private GasStation() {
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        final int totalGas = arraySum(gas);
        final int totalCost = arraySum(cost);
        if (totalCost > totalGas) {
            return -1;
        }
        int currentIndex = 0;
        int curSum = 0;
        int index = 0;
        while ((index - currentIndex) != gas.length && totalGas != curSum) {
            curSum += (gas[index % gas.length] - cost[index % gas.length]);
            if (curSum < 0) {
                while ((gas[currentIndex] - cost[currentIndex] < 0 || curSum < 0) && currentIndex <= index) {
                    curSum -= (gas[currentIndex] - cost[currentIndex]);
                    currentIndex++;
                }
            }
            index++;
        }
        return currentIndex;
    }

    private static int arraySum(int[] cost) {
        int totalCost = 0;
        for (int i : cost) {
            totalCost += i;
        }
        return totalCost;
    }
}
