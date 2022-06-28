package com.rick.problems;


public class HammingDistance {

    public static void main(String[] args) {
        int x = 93, y = 73;
        int res = new HammingDistance().hammingDistance(x, y);
        System.out.println(res);
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
