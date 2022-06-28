package com.rick.problems.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 5};
        Solution obj = new ShuffleAnArray().new Solution(nums);
        int[] param_1 = obj.reset();
        for (int i : param_1) System.out.print(i + " ");
        int[] param_2 = obj.shuffle();
        for (int i : param_2) System.out.print(i + " ");

        Integer[] param_3 = obj.shuffleByCollections();
        for (Integer i : param_3) System.out.print(i + " ");
    }

    class Solution {
        private int[] nums; // field，保存原始「陣列」

        public Solution(int[] nums) { // 建構子
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] arr = nums.clone();
            for (int i = 0; i < nums.length; i++) {
                int temp = arr[i], r = new Random().nextInt(nums.length);
                arr[i] = arr[r];
                arr[r] = temp;
            }
            return arr;
        }

        public Integer[] shuffleByCollections() {
            // change int[] to Integer[]
            Integer[] integers = new Integer[nums.length];
            for (int i = 0; i < integers.length; i++) integers[i] = nums[i];

            List<Integer> tmp = Arrays.asList(integers); // line 1
            Collections.shuffle(tmp); // line 2
            return tmp.stream().toArray(Integer[]::new); // line 3
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
}

