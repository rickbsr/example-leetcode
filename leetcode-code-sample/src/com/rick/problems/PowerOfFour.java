package com.rick.problems;

public class PowerOfFour {

    public static void main(String[] args) {
        int num = 6;
        boolean res = new PowerOfFour().isPowerOfFour(num);
        System.out.println(res);
    }

    public boolean isPowerOfFour(int num) {

        // 代表為 2 的指數
        if (num > 0 && (num & num - 1) == 0) {

            // 代表為 4 的指數
            return (num & 0x55555555) == num;
        }

        return false;
    }
}
