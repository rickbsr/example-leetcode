package com.rick.problems;

public class DivisorGame {

    public static void main(String[] args) {
        int N = 4;
        boolean res = new DivisorGame().divisorGame(N);
        System.out.println(res);
    }

    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
