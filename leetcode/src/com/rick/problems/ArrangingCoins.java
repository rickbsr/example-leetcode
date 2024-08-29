package com.rick.problems;

public class ArrangingCoins {

    public static void main(String[] args) {
        int n = 8;
        int res = new ArrangingCoins().arrangeCoins(n);
        System.out.println(res);
    }

    public int arrangeCoins(int n) {
        for (int i = 1; ; i++)
            if (n >= i) n -= i;
            else return i - 1;
    }
}
