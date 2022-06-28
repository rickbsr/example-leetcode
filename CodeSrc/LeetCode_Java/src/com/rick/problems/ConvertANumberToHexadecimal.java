package com.rick.problems;

public class ConvertANumberToHexadecimal {

    public static void main(String[] args) {
        int num = 44;
        String res = new ConvertANumberToHexadecimal().toHex(num);
        System.out.println(res);
    }

    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int j; num != 0; num >>>= 4)
            sb.append((char) ((j = num & 15) < 10 ? '0' + j : 'a' + j - 10));
        return sb.reverse().toString();
    }
}
