package com.rick.problems;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1};
        int res = new MaximumSubarray().maxSubArray(nums);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum, 0) + nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
