package com.rick.problems;

public class SortArrayByParityII {

    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        int[] res = new SortArrayByParityII().sortArrayByParityII(A);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] sortArrayByParityII(int[] A) {

        // 用於放答案的空陣列
        int[] res = new int[A.length];

        // index
        int odd = 1, even = 0;
        for (int i : A) {
            if (i % 2 == 1) {
                res[odd] = i;
                odd += 2;
            } else {
                res[even] = i;
                even += 2;
            }
        }
        return res;
    }
}
