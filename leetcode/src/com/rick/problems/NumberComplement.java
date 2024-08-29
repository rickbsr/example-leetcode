package com.rick.problems;

public class NumberComplement {

    public static void main(String[] args) {
        int num = 5;
        int res = new NumberComplement().findComplement(num);
        System.out.println(res);
    }

    public int findComplement(int num) {
        int temp = Integer.highestOneBit(num) - 1;
        return ~num & temp;
    }
}
