package com.rick.problems;

import java.util.Arrays;

public class PartitionArrayIntoThreePartsWithEqualSum {

    public static void main(String[] args) {
        int[] A = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        boolean res = new PartitionArrayIntoThreePartsWithEqualSum().canThreePartsEqualSum(A);
        System.out.println(res);
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum(), temp = 0;
        if (A.length < 3 || sum % 3 != 0) return false;
        for (int i = 0; i < A.length; i++) {
            temp += A[i];
            if (sum / 3 == temp) temp = 0;
        }
        return temp == 0;
    }
}
