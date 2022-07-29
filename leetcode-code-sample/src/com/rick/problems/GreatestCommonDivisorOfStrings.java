package com.rick.problems;

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "AB";
        String res = new GreatestCommonDivisorOfStrings().gcdOfStrings(str1, str2);
        System.out.println(res);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        if (!str2.startsWith(str1)) return "";
        if (str2.length() % str1.length() == 0) return str1;
        return gcdOfStrings(str1, str2.substring(str1.length()));
    }
}
