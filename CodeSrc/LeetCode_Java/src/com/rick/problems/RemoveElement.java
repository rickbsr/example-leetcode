package com.rick.problems;

public class RemoveElement {

    public static void main(String[] args) {
        int nums[] = {1, 3, 4, 5}, val = 4;
        int res = new RemoveElement().removeElement(nums, val);
        for (int i = 0; i < res; i++) System.out.print(nums[i] + " ");
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {

            // 如果該項不是 val
            if (nums[j] != val) {

                // 則直接往前移動
                nums[i] = nums[j];
                i++;
            }
        }
        return nums.length == 0 ? 0 : i;
    }
}
