package com.rick.problems;

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        int a = 1, b = 3;
        int res = new SumOfTwoIntegers().getSum(a, b);
        System.out.println(res);
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = ((a & b) << 1);
            a ^= b;
            b = carry;
        }
        return a;
    }
}
