package com.rick.problems;

public class NumberOf1Bits {

    public static void main(String[] args) {
        int n = 3;
        int res = new NumberOf1Bits().hammingWeight(n);
        System.out.println(res);
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
