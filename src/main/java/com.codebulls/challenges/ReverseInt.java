package com.codebulls.challenges;

public class ReverseInt {

    public static void main(String[] args) {
        int input = -2147483648;
        System.out.println("Reversed integer: " + reversePerformance(input));
        int input2 = -123;
        System.out.println("Reversed integer: " + reversePerformance(input2));
        int input3 = 1534236469;
        System.out.println("Reversed integer: " + reversePerformance(input3));
        int input4 = 0;
        System.out.println("Reversed integer: " + reversePerformance(input4));
    }

    public static int reversePerformance(int x) {
        long reversed = 0; // Use long to handle overflow during reversal
        while (x != 0) {
            int digit = x % 10; // Get the last digit
            reversed = reversed * 10 + digit; // Append the digit to the reversed number
            x /= 10; // Remove the last digit from x
        }
        // Check for overflow and return 0 if it occurs
        if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) reversed; // Cast back to int before returning
    }

    public static int reverse(int x) {
        if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }

        boolean isNegative = x < 0;
        long reversed;
        // Use long to handle overflow during reversal
        x = Math.abs(x);
        String reversedString = new StringBuilder(String.valueOf(x)).reverse().toString();
        reversed = Long.parseLong(reversedString);
        if (reversed <= Integer.MIN_VALUE || reversed >= Integer.MAX_VALUE) {
            return 0;
        }

        if (isNegative) {
            reversed = -reversed; // Make x positive for easier reversal
        }
        return (int) reversed; // Cast back to int before returning
    }


}
