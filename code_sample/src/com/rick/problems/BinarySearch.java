package com.rick.problems;

public class BinarySearch {

    public static void main(String[] args) {
        int nums[] = {-1, 0, 3, 5, 9, 12}, target = 9;
        int res = new BinarySearch().search(nums, target);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else {
                if (nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
