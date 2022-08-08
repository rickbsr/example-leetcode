package com.rick.problems.easy;

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int nums[] = {5, 8, 9}, k = 1;
        double res;
        res = new MaximumAverageSubarrayIBruteForce().findMaxAverage(nums, k);
        res = new MaximumAverageSubarrayIDiff().findMaxAverage(nums, k);
        res = new MaximumAverageSubarrayIDiffOneLoop().findMaxAverage(nums, k);
        System.out.println(res);
    }
}

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

class MaximumAverageSubarrayIDiff {
    public double findMaxAverage(int[] nums, int k) {
        int tempSum = 0, maxSum;
        for (int i = 0; i < k; i++) tempSum += nums[i]; // 建立基準值

        maxSum = tempSum;
        for (int i = k; i < nums.length; i++) {
            tempSum += nums[i] - nums[i - k]; // diff
            maxSum = Math.max(maxSum, tempSum);
        }
        return ((double) maxSum) / k;
    }
}

class MaximumAverageSubarrayIDiffOneLoop {
    public double findMaxAverage(int[] nums, int k) {
        int tempSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tempSum += (i <= k - 1) ? nums[i] : nums[i] - nums[i - k];
            if (i >= k - 1 && tempSum > maxSum) maxSum = tempSum;
        }
        return ((double) maxSum) / k;
    }
}