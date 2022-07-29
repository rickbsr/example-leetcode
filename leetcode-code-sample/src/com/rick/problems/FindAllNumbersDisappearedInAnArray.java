package com.rick.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1};
        List<Integer> res = new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums);
        System.out.println(res);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            // print-1
            System.out.println(nums[nums[i] - 1] + ", " + nums[i]);

            // 如果 nums[nums[i] - 1] 不等於 num
            if (nums[nums[i] - 1] != nums[i]) {
                // 交換
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--;
            }

            // print-2
            for (int ii : nums) System.out.print(ii + " ");
            System.out.println();
        }

        // 找出缺失項
        for (int j = 0; j < nums.length; j++)
            if (nums[j] != j + 1) res.add(j + 1);
        return res;
    }
}
