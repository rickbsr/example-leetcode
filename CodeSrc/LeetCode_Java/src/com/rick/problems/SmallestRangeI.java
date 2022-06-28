package com.rick.problems;

import java.util.Arrays;

public class SmallestRangeI {

    public static void main(String[] args) {
        int A[] = {0, 10}, K = 2;
        int res = new SmallestRangeI().smallestRangeI(A, K);
        System.out.println(res);
    }

    public int smallestRangeI(int[] A, int K) {
        // 對陣列進行排列
        Arrays.sort(A);

        // 計算最大值與最小值的差距
        int res = A[A.length - 1] - A[0] - (2 * K);

        // 返回差值, 若若差值是小於 0, 則返回 0
        return (res <= 0) ? 0 : res;
    }
}
