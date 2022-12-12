package com.leetcode.array;

public final class LemonadeChange {

    public static final int MAX_BILL = 20;
    public static final int FIVE = 5;
    public static final int TEN = 10;

    private LemonadeChange() {
    }

    public static boolean lemonadeChange(int[] bills) {
        int[] money = new int[MAX_BILL + 1];
        for (int bill : bills) {
            if (bill != FIVE && !giveChange(money, bill)) {
                return false;
            }
            money[bill]++;
        }
        return true;
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    private static boolean giveChange(int[] money, int bill) {
        if (bill == TEN) {
            if (money[FIVE] > 0) {
                money[FIVE]--;
            } else {
                return false;
            }
        } else {
            if (money[TEN] > 0 && money[FIVE] > 0) {
                money[TEN]--;
                money[FIVE]--;
            } else {
                if (money[FIVE] > 2) {
                    money[FIVE] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
