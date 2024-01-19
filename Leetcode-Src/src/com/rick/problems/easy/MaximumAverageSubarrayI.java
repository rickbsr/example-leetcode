package com.rick.problems.easy;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = {5, 8, 9};
        int k = 1;
        double res;
        res = new MaximumAverageSubarrayIBruteForce().findMaxAverage(nums, k);
        res = new MaximumAverageSubarrayIDiff().findMaxAverage(nums, k);
        System.out.println(res);
    }
}

/**
 * 方式一、暴力演算法
 */
class MaximumAverageSubarrayIBruteForce {
    public double findMaxAverage(int[] nums, int k) {
        int tempSum, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            tempSum = 0;
            for (int j = 0; j < k; j++) tempSum += nums[i + j];
            maxSum = Math.max(maxSum, tempSum);
        }
        return ((double) maxSum) / k;
    }
}

/**
 * 方式二、差異法
 */
class MaximumAverageSubarrayIDiff {
    public double findMaxAverage(int[] nums, int k) {
        int tempSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tempSum += (i <= k - 1) ? nums[i] : nums[i] - nums[i - k];
            if (i >= k - 1 && tempSum > maxSum) maxSum = tempSum;
        }
        return ((double) maxSum) / k;
    }
}