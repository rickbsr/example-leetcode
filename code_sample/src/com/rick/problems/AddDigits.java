package com.rick.problems;

public class AddDigits {

    public static void main(String[] args) {
        int num = 138;
        int res = new AddDigits().addDigits(num);
        System.out.println(res);
    }

    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
