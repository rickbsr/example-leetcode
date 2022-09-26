package com.rick.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {

    public static void main(String[] args) {
        int[] nums = {1, 5, 66, 54, 5, 49, 6, 2, 4, 5, 4, 56, 6, 8, 7, 6, 5, 4, 7};
        Solution obj = new RandomPickIndex().new Solution(nums);
        System.out.println(obj.pick(54));
    }

    class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
                if (target == nums[i]) list.add(i);
            return list.get(new Random().nextInt(list.size()));
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */