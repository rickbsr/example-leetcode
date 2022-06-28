package com.rick.problems.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int res = new MissingNumber().missingNumber(nums);
        System.out.println(res);
    }

    public int missingNumber(int[] nums) {
        // calc Sum by Trapezoid Formula
        int sum = (nums.length + 1) * nums.length / 2;
        for (int n : nums) sum -= n; // 減去陣列所有項之總和
        return sum;
    }

    public int missingNumberBySumWithJava8(int[] nums) {
        return (nums.length + 1) * nums.length / 2
                - IntStream.of(nums).sum();
    }

    public int missingNumberBySoft(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            if (i != nums[i])return i;
        return nums.length;
    }

    public int missingNumberByXor(int[] nums) {
        int check = 0;
        for (int i = 0; i < nums.length; i++) check ^= nums[i] ^ (i + 1);
        return check;
    }
}
