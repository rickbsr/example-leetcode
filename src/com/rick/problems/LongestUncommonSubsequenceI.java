package com.rick.problems;

public class LongestUncommonSubsequenceI {

    public static void main(String[] args) {
        String a = "", b = "";
        int res = new LongestUncommonSubsequenceI().findLUSlength(a, b);
        System.out.println(res);
    }

    public int findLUSlength(String a, String b) {

        // 如果兩字串相同，返回 -1
        if (a.equals(b)) return -1;

        return Math.max(a.length(), b.length());
    }
}
