package com.ll;

public class Calc {
    public static int run(String expression) {
        if (expression.contains("+")) {
            String[] bits = expression.split("\\s*\\+\\s*");
            return sum(bits, 0);
        }

        String[] bits = expression.split("\\s*-\\s*");
        int num1 = Integer.parseInt(bits[0].trim());
        int num2 = Integer.parseInt(bits[1].trim());

        return subtract(num1, num2);
    }

    private static int sum(String[] bits, int idx) {
        if (idx == bits.length) return 0;
        return Integer.parseInt(bits[idx].trim()) + sum(bits, idx + 1);
    }

    private static int subtract(int num1, int num2) {
        if (num2 == 0) return num1;
        if (num2 > 0) return subtract(num1 - 1, num2 - 1);
        return subtract(num1 + 1, num2 + 1);
    }

}
