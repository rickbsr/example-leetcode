package com.rick.problems;

public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = {3, 3, 4};
        boolean res = new NonDecreasingArray().checkPossibility(nums);
        System.out.println(res);
    }

    public boolean checkPossibility(int[] nums) {
        for (int i = 0, count = 0, n = nums.length; i <= n - 2; i++)
            if (nums[i] > nums[i + 1])
                if (++count == 2 || (i > 0 && nums[i - 1] > nums[i + 1] && i < n - 2 && nums[i] > nums[i + 2])) return false;
        return true;
    }
}
