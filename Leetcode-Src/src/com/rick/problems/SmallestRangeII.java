package com.rick.problems;

import java.util.Arrays;

public class SmallestRangeII {

    public static void main(String[] args) {
        int A[] = {1, 3, 6}, K = 3;
        int res = new SmallestRangeII().smallestRangeII(A, K);
        System.out.println(res);
    }

    public int smallestRangeII(int[] A, int K) {
        // 對陣列進行排列
        Arrays.sort(A);

        // 求出最大與最小值的差
        int res = A[A.length - 1] - A[0];

        for (int i = 0; i < A.length - 1; i++) {
            // 判斷最大值
            int high = Math.max(A[A.length - 1] - K, A[i] + K);
            // 判斷最小值
            int low = Math.min(A[0] + K, A[i + 1] - K);
            // 返回最小差距
            res = Math.min(res, high - low);
        }
        return res;
    }
}
