package com.rick.problems;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2, 7, 1, 3, 1, 9, 3, 1, 1};
        int res = new HouseRobber().rob(nums);
        System.out.println(res);
    }

    public int rob(int[] nums) {
        int rob = 0, noRob = 0;
        for (int now : nums) {
            int temp = rob;
            rob = noRob + now;
            noRob = Math.max(noRob, temp);
        }
        return Math.max(rob, noRob);
    }
}
