package com.rick.problems;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6}, target = 7;
        int res = new SearchInsertPosition().searchInsert(nums, target);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            if (target <= nums[i]) return i;
        return nums.length;
    }
}
