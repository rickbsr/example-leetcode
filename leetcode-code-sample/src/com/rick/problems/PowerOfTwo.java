package com.rick.problems;

public class PowerOfTwo {

    public static void main(String[] args) {
        int n = 1024;
        boolean res = new PowerOfTwo().isPowerOfTwo(n);
        System.out.println(res);
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
