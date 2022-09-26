package com.rick.problems;

public class ReverseInteger {

    public static void main(String[] args) {
        int i = -1123;
        int res = new ReverseInteger().reverse(i);
        System.out.println(res);
    }

    public int reverse(int x) {
        // 解決 int 反轉後可能溢出的問題
        long res = 0;
        while (x != 0) {
            res *= 10; // 將原本的數進位
            res += x % 10; // 然後加上 x 的最末位
            x /= 10; // 因為是整數型別，我們可以透過 /10 來去除個位數

            // 判斷該數值是否超出範圍，是則 return 0
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        // 記得轉型回為 int
        return (int) res;
    }
}
