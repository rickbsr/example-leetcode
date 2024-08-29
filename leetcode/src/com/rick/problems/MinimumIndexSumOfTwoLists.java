package com.rick.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"}, list2 = {"KFC", "Shogun", "Burger King"};
        String[] res = new MinimumIndexSumOfTwoLists().findRestaurant(list1, list2);
        for (String str : res) System.out.println(str);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = null;
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map1.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) map2.put(list2[i], i);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++)
            if (map2.containsKey(list1[i])) {
                int sum = map1.get(list1[i]) + map2.get(list1[i]);
                if (sum < min) {
                    min = sum;
                    result = new ArrayList<>();
                    result.add(list1[i]);
                } else if (sum == min) result.add(list1[i]);
            }
        return result.toArray(new String[result.size()]);
    }
}