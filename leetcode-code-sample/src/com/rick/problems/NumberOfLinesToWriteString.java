package com.rick.problems;

public class NumberOfLinesToWriteString {

    public static void main(String[] args) {
        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String S = "bbbcccdddaaa";
        int[] res = new NumberOfLinesToWriteString().numberOfLines(widths, S);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] numberOfLines(int[] widths, String S) {
        int sum = 0;
        for (char c : S.toCharArray()) {
            if (sum % 100 + widths[c - 'a'] > 100) sum += 100 - sum % 100;
            sum += widths[c - 'a'];
        }
        return new int[]{(sum / 100) + 1, sum % 100};
    }
}
