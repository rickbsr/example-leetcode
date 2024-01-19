package com.rick.problems;


public class RotateArray {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7}, k = 1;
        new RotateArray().rotate(nums, k);
        for (int i : nums) System.out.print(i + " ");
    }

    public void rotate(int[] nums, int k) {

        // 特殊情況排除
        if (nums == null || nums.length <= 1) return;

        // 求 k 除 陣列長度的餘數, 避免 k 超過陣列長度
        k %= nums.length;

        // 第一次翻轉
        reverse(nums, 0, nums.length - 1);

        // 第二次翻轉
        reverse(nums, 0, k - 1);

        // 第三次翻轉
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int s, int e) {

        // s 為起始項, e 為末項, 若 s >= e, 則代表已經交錯, 也就是說已翻轉完畢
        while (s < e) {

            // 將 nums[s] 放到暫存空間
            int temp = nums[s];

            // 然後置換 nums[s] 的內容為 nums[e]
            nums[s] = nums[e];

            // 最後將 temp 的內容放到 nums[e] 完成一次的置換
            nums[e] = temp;

            // 往下一位, 別忘了 s++, e--
            s++;
            e--;
        }
    }
}
