package com.rick.problems.easy;

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

/**
 * 方式一、容器法
 */
class FindTheDifferenceContainer {
    public char findTheDifference(String s, String t) {
        List<Character> characterList = new ArrayList<>();
        for (Character c : t.toCharArray()) characterList.add(c);
        for (Character c : s.toCharArray()) characterList.remove(c);
        return characterList.iterator().next();
    }
}

/**
 * 方式二、排序法
 */
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

/**
 * 方式三、扣除法
 */
class FindTheDifferenceSub {
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (int c : t.toCharArray()) res += c;
        for (int c : s.toCharArray()) res -= c;
        return (char) res;
    }
}

/**
 * 方式四、互斥或法
 */
class FindTheDifferenceXor {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : (t + s).toCharArray()) res ^= c;
        return res;
    }
}
