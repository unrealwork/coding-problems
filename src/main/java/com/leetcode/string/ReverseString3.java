package com.leetcode.string;

public final class ReverseString3 {
    private ReverseString3() {

    }

    public static String reverseWords(String s) {
        char[] sArray = s.toCharArray();
        int i = 0;
        int j = 0;
        while (j < sArray.length) {
            i = nextIndex(sArray, j, false);
            j = nextIndex(sArray, i, true);
            reverse(sArray, i, j);
        }
        return new String(sArray);
    }


    private static int nextIndex(char[] s, int start, boolean isWhitespace) {
        int i = start;
        while (i < s.length) {
            if ((s[i] == ' ') == isWhitespace) {
                break;
            }
            i++;
        }
        return i;
    }

    private static void reverse(char[] s, int start, int end) {
        int i = start;
        int j = end - 1;
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
}
