package com.rick.problems.easy;

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int nums[] = {5}, k = 1;
        double res = new MaximumAverageSubarrayI().findMaxAverageBruteForce(nums, k);
        System.out.println(res);
    }

    public double findMaxAverageBruteForce(int[] nums, int k) {
        int tempSum, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            tempSum = 0;
            for (int j = 0; j < k; j++) {
                tempSum += nums[i + j];
            }
            maxSum = Math.max(maxSum, tempSum);
        }
        return ((double) maxSum) / k;
    }

    public double findMaxAverageOptimized(int[] nums, int k) {
        int tempSum = 0, maxSum;
        for (int i = 0; i < k; i++) {
            tempSum += nums[i];
        }
        maxSum = tempSum;
        for (int i = k; i < nums.length; i++) {
            tempSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, tempSum);
        }
        return ((double) maxSum) / k;
    }

    public double findMaxAverageOneForLoop(int[] nums, int k) {
        int tempSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tempSum += (i <= k - 1) ? nums[i] : nums[i] - nums[i - k];
            if (i >= k - 1 && tempSum > maxSum) maxSum = tempSum;
        }
        return ((double) maxSum) / k;
    }
}
