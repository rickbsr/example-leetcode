package com.rick.problems;

public class NimGame {

    public static void main(String[] args) {
        int n = 103;
        boolean res = new NimGame().canWinNim(n);
        System.out.println(res);
    }

    public boolean canWinNim(int n) {

        // 不為 4 個倍數
        return n % 4 != 0;
    }
}
