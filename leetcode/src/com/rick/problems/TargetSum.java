package com.rick.problems;

public class TargetSum {

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1, 1}, S = 3;
        int res = new TargetSum().findTargetSumWays(nums, S);
        System.out.println(res);
    }

    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0);
    }

    private int dfs(int[] nums, int S, int idx) {
        if (idx >= nums.length) return S == 0 ? 1 : 0;
        return dfs(nums, S + nums[idx], idx + 1) + dfs(nums, S - nums[idx], idx + 1);
    }
}
