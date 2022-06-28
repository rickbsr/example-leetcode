package com.rick.problems;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int res = new RomanToInteger().romanToInt(s);
        System.out.println(res);
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int i = s.length(), res = map.get(s.charAt(i - 1));
        for (i -= 2; i >= 0; i--)
            res += (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)) ? 1 : -1) * map.get(s.charAt(i));
        return res;
    }
}
