package com.rick.problems;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int n = 1;
        String res = new ExcelSheetColumnTitle().convertToTitle(n);
        System.out.println(res);
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (--n >= 0) {
            sb.append((char) ((n % 26) + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
