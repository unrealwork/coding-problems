package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

final class RestoreIPAddresses {

    private static final int DECIMAL_BASE = 10;
    private static final int IP_PART_LIMIT = 0xFF;
    private static final int IP_TOTAL_PARTS = 4;
    private static final int IP_PART_SIZE = 3;

    private RestoreIPAddresses() {

    }

    static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int[] splitIndexes = new int[IP_TOTAL_PARTS];
        restoreIpAddressesRec(s, res, splitIndexes, 0);
        return res;
    }

    private static void restoreIpAddressesRec(String s, List<String> res, int[] splitIndexes, int currentPart) {
        int restLength = restLength(s, splitIndexes, currentPart);
        if (currentPart == IP_TOTAL_PARTS && restLength == 0) {
            res.add(splitAsIp(s, splitIndexes));
            return;
        }
        if (canBeRestoredWithRestLength(splitIndexes, currentPart, restLength)) {
            handleCurrentIpPart(s, res, splitIndexes, currentPart);
        }
    }

    private static void handleCurrentIpPart(String s, List<String> res, int[] splitIndexes, int currentPart) {
        int leftIndex = partLeftIndex(splitIndexes, currentPart);
        char firstSymbol = s.charAt(leftIndex);
        if (Character.isDigit(firstSymbol)) {
            splitIndexes[currentPart] = leftIndex + 1;
            restoreIpAddressesRec(s, res, splitIndexes, currentPart + 1);
            boolean isLeadingZero = firstSymbol == '0';
            if (!isLeadingZero) {
                int partValue = firstSymbol - '0';
                for (int rightShift = 1; rightShift < IP_PART_SIZE; rightShift++) {
                    int rightIndex = leftIndex + rightShift;
                    if (rightIndex == s.length()) {
                        break;
                    }
                    final char rightSymbol = s.charAt(rightIndex);
                    partValue = partValue * DECIMAL_BASE + rightSymbol - '0';
                    if (Character.isDigit(rightSymbol) && partValue <= IP_PART_LIMIT) {
                        splitIndexes[currentPart] = rightIndex + 1;
                        restoreIpAddressesRec(s, res, splitIndexes, currentPart + 1);
                    }
                }
            }
        }
    }

    private static int partLeftIndex(int[] splitIndexes, int currentPart) {
        if (currentPart == 0) {
            return 0;
        }
        return splitIndexes[currentPart - 1];
    }

    private static boolean canBeRestoredWithRestLength(int[] splitIndexes, int currentPart, int restLength) {
        int leftParts = IP_TOTAL_PARTS - currentPart;
        return currentPart < splitIndexes.length && restLength >= leftParts && restLength <= leftParts * IP_PART_SIZE;
    }

    private static String splitAsIp(String s, int[] splitIndexes) {
        int leftIndex = 0;
        StringBuilder ip = new StringBuilder();
        for (int splitIndex : splitIndexes) {
            if (leftIndex > 0) {
                ip.append('.');
            }
            ip.append(s, leftIndex, splitIndex);
            leftIndex = splitIndex;
        }
        return ip.toString();
    }

    private static int restLength(String s, int[] splitIndexes, int currentPart) {
        if (currentPart == 0) {
            return s.length();
        }
        return s.length() - splitIndexes[currentPart - 1];
    }
}
