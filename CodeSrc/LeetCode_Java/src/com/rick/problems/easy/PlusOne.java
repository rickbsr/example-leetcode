package com.rick.problems.easy;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] res = new PlusOne().plusOne(digits);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--)
            if (digits[i] != 9) { // 若不等於 9，則直接對該項「+1」，並返回結果
                digits[i]++;
                return digits;
            } else digits[i] = 0; // 若為 9，則歸「0」，並持續下一位數的判斷
        digits = new int[digits.length + 1]; // 代表全部為 9，則產生「進位陣列」
        digits[0] = 1; // 「首位為 1」
        return digits;
    }
}
