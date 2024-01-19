package com.rick.problems;

import java.util.HashMap;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        int nums[] = {1, 0, 6, 1}, k = 1;
        boolean res = new ContainsDuplicateII().containsNearbyDuplicate(nums, k);
        System.out.println(res);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 判斷 key 是否存在
            if (map.containsKey(nums[i])) {
                // 判斷它是否距離小於等於 k
                if (i - map.get(nums[i]) <= k) return true;
                else { // 若不是，代表大於 k
                    map.remove(nums[i]); // 移除
                    map.put(nums[i], i); // 再加入
                }
            } else map.put(nums[i], i); // 若不存在則它加入 map
        }
        return false;
    }
}
