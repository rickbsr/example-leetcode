package com.rick.problems;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        boolean res = new HappyNumber().isHappy(n);
        System.out.println(res);
    }

    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (n == 4 || n == 16 || n == 37 || n == 58 || n == 89 || n == 145 || n == 42 || n == 20) return false;
        int sum = 0;
        for (; n > 0; n /= 10) sum += (int) Math.pow(n % 10, 2);
        return isHappy(sum);
    }
}
