package com.rick.problems;

public class Base7 {

    public static void main(String[] args) {
        int num = 100;
        String res = new Base7().convertToBase7(num);
        System.out.println(res);
    }

    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}
