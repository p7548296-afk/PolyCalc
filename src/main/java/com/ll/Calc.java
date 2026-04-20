package com.ll;

public class Calc {
    public static int run(String expression) {
        String normalized = removeSpaces(expression, 0);
        if (normalized.isEmpty()) {
            return 0;
        }

        int firstOpIdx = findFirstOperator(normalized, 0);
        if (firstOpIdx == -1) {
            return Integer.parseInt(normalized);
        }

        int firstNumber = Integer.parseInt(normalized.substring(0, firstOpIdx));
        return evalTail(normalized, firstOpIdx, firstNumber);
    }

    private static int evalTail(String expression, int opIdx, int acc) {
        if (opIdx >= expression.length()) {
            return acc;
        }

        char op = expression.charAt(opIdx);
        int nextOpIdx = findFirstOperator(expression, opIdx + 1);
        int nextValue = nextOpIdx == -1
                ? Integer.parseInt(expression.substring(opIdx + 1))
                : Integer.parseInt(expression.substring(opIdx + 1, nextOpIdx));

        int nextAcc = op == '+' ? acc + nextValue : acc - nextValue;

        if (nextOpIdx == -1) {
            return nextAcc;
        }

        return evalTail(expression, nextOpIdx, nextAcc);
    }

    private static int findFirstOperator(String expression, int idx) {
        if (idx >= expression.length()) {
            return -1;
        }

        char c = expression.charAt(idx);
        if (c == '+' || c == '-') {
            return idx;
        }

        return findFirstOperator(expression, idx + 1);
    }

    private static String removeSpaces(String expression, int idx) {
        if (idx >= expression.length()) {
            return "";
        }

        char c = expression.charAt(idx);
        String tail = removeSpaces(expression, idx + 1);

        if (Character.isWhitespace(c)) {
            return tail;
        }

        return c + tail;
    }
}
