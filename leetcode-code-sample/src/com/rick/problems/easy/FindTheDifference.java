package com.rick.problems.easy;

public class FindTheDifference {

    public static void main(String[] args) {
        String s = "abcd", t = "aebcd";
        char res = new FindTheDifference().findTheDifference(s, t);
        System.out.println(res);
    }

    public char findTheDifference(String s, String t) {
        int res = 0;
        for (int c : t.toCharArray()) res += c; // 計算 t 的總值
        for (int c : s.toCharArray()) res -= c; // 扣去 s 的總值
        return (char) res; // 將剩餘的值轉乘對應照的文字
    }
}
