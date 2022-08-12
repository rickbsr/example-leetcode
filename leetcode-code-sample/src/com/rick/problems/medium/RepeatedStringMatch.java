package com.rick.problems.medium;

public class RepeatedStringMatch {

    public static void main(String[] args) {
        String a = "abc", b = "cabcabca";
        int res = new RepeatedStringMatchLength().repeatedStringMatch(a, b);
        System.out.println(res);
    }
}

class RepeatedStringMatchLength {
    public int repeatedStringMatch(String a, String b) {
        int n = (int) Math.ceil((double) b.length() / a.length());
        return a.repeat(n).contains(b) ? n : a.repeat(n + 1).contains(b) ? n + 1 : -1;
    }
}