package com.rick.problems;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 3;
        int res = new ClimbingStairs().climbStairs(n);
        System.out.println(res);
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int oneStep = 1, twoStep = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = res;
        }
        return res;
    }
}
