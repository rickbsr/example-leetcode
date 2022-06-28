package com.rick.problems;

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        int[] res = new SortArrayByParity().sortArrayByParity(A);
        for (int i : res) System.out.print(i + " ");

    }

    public int[] sortArrayByParity(int[] A) {
        // 用於放答案的空陣列
        int[] res = new int[A.length];

        // index
        int s = 0, e = A.length - 1;
        for (int i : A) {
            if (i % 2 == 0) res[s++] = i;
            else res[e--] = i;
        }
        return res;
    }
}
