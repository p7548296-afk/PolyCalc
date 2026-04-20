package com.ll;

public class Calc {
    public static int run(String expression) {
        if (expression.contains(" + ")) {
            String[] expressionBits = expression.split(" \\+ ");

            int num1 = Integer.parseInt(expressionBits[0]);
            int num2 = Integer.parseInt(expressionBits[1]);

            return num1 + num2;
        }

        String[] expressionBits = expression.split(" - ");

        int num1 = Integer.parseInt(expressionBits[0]);
        int num2 = Integer.parseInt(expressionBits[1]);

        return subtract(num1, num2);
    }

    private static int subtract(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }

        if (num2 > 0) {
            return subtract(num1 - 1, num2 - 1);
        }

        return subtract(num1 + 1, num2 + 1);
    }

}
