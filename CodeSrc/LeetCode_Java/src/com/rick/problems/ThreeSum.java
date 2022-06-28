package com.rick.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ThreeSum().threeSum(nums);
        System.out.println(res);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1, target = -nums[i];
            while (low < high)
                if (low != i + 1 && nums[low] == nums[low - 1]) low++;
                else {
                    int sum = nums[low] + nums[high];
                    if (sum > target) high--;
                    else if (sum < target) low++;
                    else res.add(new ArrayList<>(Arrays.asList(nums[i], nums[low++], nums[high--])));
                }
        }
        return res;
    }
}
