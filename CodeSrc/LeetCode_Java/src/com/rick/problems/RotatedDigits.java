package com.rick.problems;

public class RotatedDigits {

    public static void main(String[] args) {
        int N = 100;
        int res = new RotatedDigits().rotatedDigits(N);
        System.out.println(res);
    }

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) if (isValid(i)) count++;
        return count;
    }

    private boolean isValid(int num) {
        boolean b = false;
        for (; num > 0; num /= 10) {
            switch (num % 10) {
                case 3:
                case 4:
                case 7:
                    return false;
                case 2:
                case 5:
                case 6:
                case 9:
                    b = true;
            }
        }
        return b;
    }
}
