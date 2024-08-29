package com.rick.problems;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int res = new MaximumProductOfThreeNumbers().maximumProduct(nums);
        System.out.println(res);
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }
}
