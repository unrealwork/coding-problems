package com.leetcode.string;

public final class GoalParserInterpretation {
    private GoalParserInterpretation() {
    }

    public static String interpret(String command) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
                i++;
            } else {
                if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i += 2;
                } else {
                    sb.append("al");
                    i += 4;
                }
            }
        }
        return sb.toString();
    }
}
