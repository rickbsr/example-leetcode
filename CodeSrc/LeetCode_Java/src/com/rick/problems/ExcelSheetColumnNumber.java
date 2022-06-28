package com.rick.problems;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String s = "ZZZ";
        int res = new ExcelSheetColumnNumber().titleToNumber(s);
        System.out.println(res);
    }

    public int titleToNumber(String s) {
        int res = 0;
        for (int i = s.length() - 1, j = 0; i >= 0; i--)
            res += (s.charAt(i) - 'A' + 1) * Math.pow(26, j++);
        return res;
    }
}
