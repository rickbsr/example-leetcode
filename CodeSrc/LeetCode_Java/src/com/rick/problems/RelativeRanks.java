package com.rick.problems;

import java.util.Arrays;

public class RelativeRanks {

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        String[] res = new RelativeRanks().findRelativeRanks(nums);
        for (String s : res) System.out.print(s);
        System.out.println();
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        // 複製一份原本陣列，並將原本的整數轉成字串
        for (int i = 0; i < nums.length; i++) res[i] = String.valueOf(nums[i]);
        Arrays.sort(nums);
        for (int i = 0; i < res.length; i++) {
            int rank = res.length - Arrays.binarySearch(nums, Integer.valueOf(res[i]));
            switch (rank) {
                case 1:
                    res[i] = "Gold Medal";
                    break;
                case 2:
                    res[i] = "Silver Medal";
                    break;
                case 3:
                    res[i] = "Bronze Medal";
                    break;
                default:
                    res[i] = String.valueOf(rank);
            }
        }
        return res;
    }
}
