package com.rick.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcggf";
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {

        // 如果是 null 或空值
        if (s == null || s.isEmpty()) return 0;

        Set<Character> set = new HashSet<>();
        int res = 0;

        // i 是目前的位置，j 則代表不重覆起點的位置
        for (int i = 0, j = 0; i < s.length(); ) {
            // 遇到重覆的字元
            if (set.contains(s.charAt(i))) {
                // 就把當前字元移除
                set.remove(s.charAt(j));
                // 起點位置往後移位
                j++;
            } else { // 不是重覆字元
                // 將該字元放入 set 內
                set.add(s.charAt(i));
                // 比較是否為最長字串
                res = Math.max(res, set.size());
                // 跳到下一個位置
                i++;
            }
            System.out.println(set);
        }
        return res;
    }
}
