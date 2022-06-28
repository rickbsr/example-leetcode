package com.rick.problems;

public class NumberOfSegmentsInAString {

    public static void main(String[] args) {
        String s = "";
        int res = new NumberOfSegmentsInAString().countSegments(s);
        System.out.println(res);
    }

    public int countSegments(String s) {
        return s.trim().length() == 0 ? 0 : s.trim().split("\\s+").length;
    }
}
