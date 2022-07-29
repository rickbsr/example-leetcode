package com.rick.problems;

public class RotateString {

    public static void main(String[] args) {
        String A = "aa", B = "a";
        boolean res = new RotateString().rotateString(A, B);
        System.out.println(res);
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.isEmpty()) return true;
        StringBuilder sb = new StringBuilder(A);
        for (int i = 0; i < B.length(); i++) {
            if (sb.toString().equals(B)) return true;
            else sb.append(sb.charAt(0)).deleteCharAt(0);
        }
        return false;
    }
}