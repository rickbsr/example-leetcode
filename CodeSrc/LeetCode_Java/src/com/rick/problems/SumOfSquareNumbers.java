package com.rick.problems;

public class SumOfSquareNumbers {

    public static void main(String[] args) {
        int c = 5;
        boolean res = new SumOfSquareNumbers().judgeSquareSum(c);
        System.out.println(res);
    }

    public static boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++)
            if (Math.floor(Math.sqrt(c - i * i)) == Math.sqrt(c - i * i)) return true;
        return false;
    }
}
