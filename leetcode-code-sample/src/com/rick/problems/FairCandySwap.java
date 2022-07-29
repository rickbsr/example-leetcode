package com.rick.problems;

public class FairCandySwap {

    public static void main(String[] args) {
        int[] A = {1, 1}, B = {2, 2};
        int[] res = new FairCandySwap().fairCandySwap(A, B);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int i : A) sumA += i;
        for (int i : B) sumB += i;
        int dif = (sumA - sumB) / 2;
        for (int a : A)
            for (int b : B)
                if (a - b == dif) return new int[]{a, b};
        return null;
    }
}
