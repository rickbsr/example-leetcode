package com.rick.problems.easy;

public class AddStrings {
    public static void main(String[] args) {
        String num1 = "100", num2 = "72";
        String res = new AddStringsBruteForce().addStrings(num1, num2);
        System.out.println(res);
    }
}

/**
 * 方式一、暴力演算法
 */
class AddStringsBruteForce {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length(), len2 = num2.length(), carry = 0;
        for (int i = 1; i <= Math.max(len1, len2) || carry > 0; i++) {
            int sum = carry;
            if (i <= len1) sum += num1.charAt(len1 - i) - '0';
            if (i <= len2) sum += num2.charAt(len2 - i) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}