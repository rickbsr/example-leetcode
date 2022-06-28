package com.rick.problems;

public class PowerOfThree {

    public static void main(String[] args) {
        int n = 488;
        boolean res = new PowerOfThree().isPowerOfThree(n);
        System.out.println(res);
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;

        // 如果最後等於 1，就代表它是 3 的指數
        while (n != 1) {
            if (n % 3 == 0) n /= 3;
                // 不能被 3 整除就一定不是 3 的指數
            else return false;
        }
        return true;
    }
}
