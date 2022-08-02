package com.rick.problems.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {
    public static void main(String[] args) {
        int res, nums[] = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        res = new MissingNumberSoft().missingNumber(nums);
        res = new MissingNumberSub().missingNumber(nums);
        res = new MissingNumberSubWithJava8().missingNumber(nums);
        res = new MissingNumberXor().missingNumber(nums);
        System.out.println(res);
    }
}

class MissingNumberSoft {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) if (i != nums[i]) return i;
        return nums.length;
    }
}

class MissingNumberSub {
    public int missingNumber(int[] nums) {
        // calc Sum by Trapezoid Formula
        int sum = (nums.length + 1) * nums.length / 2;
        for (int n : nums) sum -= n; // 減去陣列所有項之總和
        return sum;
    }
}

class MissingNumberSubWithJava8 {
    public int missingNumber(int[] nums) {
        return (nums.length + 1) * nums.length / 2 - IntStream.of(nums).sum();
    }
}

class MissingNumberXor {
    public int missingNumber(int[] nums) {
        int check = 0;
        for (int i = 0; i < nums.length; i++) check ^= nums[i] ^ (i + 1);
        return check;
    }
}