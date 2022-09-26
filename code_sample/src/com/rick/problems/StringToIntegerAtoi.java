package com.rick.problems;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        String str = "-2147483648";
        int res = new StringToIntegerAtoi().myAtoi(str);
        System.out.println(res);
    }

    public int myAtoi(String str) {
        int sign = 1, i = 0, res = 0;
        str = str.trim();
        if (str.isEmpty()) return 0;
        // 判斷正負
        if (str.charAt(i) == '+' || str.charAt(i) == '-') sign = 44 - str.charAt(i++);
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int temp = str.charAt(i++) - '0';
            if (res > (Integer.MAX_VALUE - temp) / 10) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + temp;
        }
        return res * sign;
    }
}
