package com.rick.problems;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int res = new MajorityElement().majorityElement(nums);
        System.out.println(res);
    }

//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                int count = map.get(num)+1;
//                if (count > nums.length / 2) return num;
//                map.put(num, count);
//            } else map.put(num, 1);
//        }
//        return nums[0];
//    }

    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            System.out.println(res);
            if (count == 0) res = num;
            if (num == res) count++;
            else count--;
        }
        return res;
    }
}