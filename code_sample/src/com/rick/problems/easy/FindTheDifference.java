package com.rick.problems.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheDifference {

    public static void main(String[] args) {
        String s = "abcd", t = "aebcd";
        char res;

        res = new FindTheDifferenceSort().findTheDifference(s, t);

        res = new FindTheDifferenceContainer().findTheDifference(s, t);

        res = new FindTheDifferenceSub().findTheDifference(s, t);

        res = new FindTheDifferenceXor().findTheDifference(s, t);

        System.out.println(res);
    }
}

class FindTheDifferenceSort {
    public char findTheDifference(String s, String t) {
        char[] sChars, tChars;

        sChars = s.toCharArray();
        tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < s.length(); i++)
            if (tChars[i] != sChars[i]) return tChars[i];

        return tChars[t.length() - 1];
    }
}

class FindTheDifferenceContainer {
    public char findTheDifference(String s, String t) {
        List<Character> characterList = new ArrayList<>();
        for (Character c : t.toCharArray()) characterList.add(c);
        for (Character c : s.toCharArray()) characterList.remove(c);
        return characterList.iterator().next();
    }
}

class FindTheDifferenceSub {
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (int c : t.toCharArray()) res += c; // 計算 t 的總值
        for (int c : s.toCharArray()) res -= c; // 扣去 s 的總值
        return (char) res; // 將剩餘的值轉乘對應照的文字
    }
}

class FindTheDifferenceXor {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : (t + s).toCharArray()) res ^= c;
        return res;
    }
}
