package com.rick.problems;

public class IntegerBreak {

    public static void main(String[] args) {
        int n = 10;
        int res = new IntegerBreak().integerBreak(n);
        System.out.println(res);
    }

    public int integerBreak(int n) {
        // 排除 2 和 3
        if (n == 2 || n == 3) return n - 1;

        // 排除 4
        if (n == 4) return 4;

        n -= 5;

        // 判斷 3 的數量
        int x = (int) Math.pow(3, (n / 3) + 1);

        // 判斷餘數
        int y = (n % 3 + 2);

        return x * y;
    }
}
