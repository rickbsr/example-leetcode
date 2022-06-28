package com.rick.problems;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        int num = 16;
        boolean res = new ValidPerfectSquare().isPerfectSquare(num);
        System.out.println(res);
    }

    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
