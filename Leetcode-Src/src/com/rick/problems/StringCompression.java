package com.rick.problems;

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a'};
        int res = new StringCompression().compress(chars);
        System.out.println(res);
    }

    public int compress(char[] chars) {
        int i = 0, j = 0;
        while (i < chars.length) {
            int count = 0;
            char current = chars[i];
            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }
            chars[j] = current;
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) chars[++j] = c;
            }
            j++;
        }
        return j;
    }
}
