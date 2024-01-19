package com.rick.problems;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "loveleetcode";
        int res = new FirstUniqueCharacterInAString().firstUniqChar(s);
        System.out.println(res);
    }

    public int firstUniqChar(String s) {

        // 用於存放配對過的字元
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            // 判斷 i 是否就是該字串的最後一個字元
            if (i == s.lastIndexOf(s.charAt(i)) &&
                    !set.contains(s.charAt(i))) // 判斷該字元是否曾經出現過
                return i;

            // 將已經判斷過的字元加入 set
            set.add(s.charAt(i));
        }
        return -1;
    }
}
