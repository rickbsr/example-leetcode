package com.rick.problems;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"cdog", "cracecar", "car"};
        String res = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(res);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String rmdr = strs[0];
        for (String str : strs) {
            while (!str.startsWith(rmdr))
                if (!rmdr.isEmpty()) rmdr = rmdr.substring(0, rmdr.length() - 1);
            if (rmdr.isEmpty()) break;
        }
        return rmdr;
    }
}
