package com.rick.problems;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {

    public static void main(String[] args) {
        int A[] = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, K = 1;
        List<Integer> res = new AddToArrayFormOfInteger().addToArrayForm(A, K);
        System.out.println(res);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        int i = A.length - 1, carry = 0;
        while (i >= 0 || K > 0 || carry > 0) {
            int a = i >= 0 ? A[i--] : 0;
            int b = K % 10;
            K = K / 10;
            int sum = a + b + carry;
            carry = sum / 10;
            res.add(0, sum % 10);
        }
        return res;
    }
}
