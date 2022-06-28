package com.rick.problems;

public class NthDigit {

    public static void main(String[] args) {
        int n = 11;
        int res = new NthDigit().findNthDigit(n);
        System.out.println(res);
    }

    public int findNthDigit(int n) {
        int len = 1, start = 1;
        long count = 9;
        // 判斷位數區間
        while (n > len * count) {
            // 扣除該區間總長度
            n -= len * count;
            len++; // 長度 + 1
            count *= 10; // 計數 * 10
            start *= 10; // 起始數 * 10
        }
        // 算出該位數
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
