package com.rick.problems;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int res = new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums);
        System.out.println(res);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int i : nums) {
            if (i == 1) cur++; // 連續計數加 1
            else cur = 0; // 歸 0
            max = Math.max(max, cur); // 取最大值
        }
        return max;
    }
}
