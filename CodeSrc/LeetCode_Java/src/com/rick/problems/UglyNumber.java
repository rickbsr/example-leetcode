package com.rick.problems;

public class UglyNumber {

    public static void main(String[] args) {
        int num = 6;
        boolean res = new UglyNumber().isUgly(num);
        System.out.println(res);
    }

    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 5 == 0) num /= 5;
        while (num % 3 == 0) num /= 3;
        while (num % 2 == 0) num /= 2;
        return num == 1;
    }
}
