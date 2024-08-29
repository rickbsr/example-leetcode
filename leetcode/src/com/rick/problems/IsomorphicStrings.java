package com.rick.problems;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        boolean res = new IsomorphicStrings().isIsomorphic(s, t);
        System.out.println(res);
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b)) continue;
                else return false;
            } else {
                if (!map.containsValue(b)) map.put(a, b);
                else return false;
            }
        }
        return true;
    }
}
