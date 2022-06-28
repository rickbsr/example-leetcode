package com.rick.problems;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        int left = 1, right = 31;
        List<Integer> res = new SelfDividingNumbers().selfDividingNumbers(left, right);
        for (int i : res) System.out.print(i + " ");
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (; left <= right; left++) {
            if (isSelfDividingNumber(left)) res.add(left);
        }
        return res;
    }

    private boolean isSelfDividingNumber(int i) {
        for (int digit = 1; i / digit > 0; digit *= 10) {
            int tmp = (i % (digit * 10)) / digit;
            if (tmp == 0 || i % tmp != 0) return false;
        }
        return true;
    }
}
