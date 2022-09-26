package com.rick.problems;

public class PowXN {

    public static void main(String[] args) {
        double x = 2;
        int n = -1;
        double res = new PowXN().myPow(x, n);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        double res = 1.0;

        // 每次除 2，直到 i 等於 0
        for (int i = n; i != 0; i /= 2) {

            // 第一次判斷時，n 可能為奇數，所以要乘一次
            if (i % 2 != 0) res *= x;

            // 每次運算為平方
            x *= x;
        }
        // 判斷 n 的正負號
        return n < 0 ? 1 / res : res;
    }
}


