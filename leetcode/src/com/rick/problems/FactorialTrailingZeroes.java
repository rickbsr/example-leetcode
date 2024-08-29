package com.rick.problems;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        int n = 25;
        int res = new FactorialTrailingZeroes().trailingZeroes(n);
        System.out.println(res);
    }

    public int trailingZeroes(int n) {
        return (n /= 5) > 0 ? n + trailingZeroes(n) : 0;
    }
}
