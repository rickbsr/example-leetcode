package com.rick.problems.easy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9}, res;

        res = new PlusOneString().plusOne(digits);
        res = new PlusOneMathSimple().plusOne(digits);
        res = new PlusOneMath().plusOne(digits);
        res = new PlusOneOneByOnFromUnitsDigit().plusOne(digits);

        for (int i : res) System.out.print(i + " ");
    }
}

class PlusOneString {

    public int[] plusOne(int[] digits) {

        StringBuilder builder = new StringBuilder();

        // 第一階段：將「數列」轉換成「數值」
        for (int digit : digits) builder.append(digit);

        int idx = lastIndexOfNotNineRegEx(builder.toString());

        // 第二階段：將「數值」轉換回「數列」
        if (idx != -1) { // 若「位數不變」
            for (int i = 0; i < digits.length; i++)  // 加「1」
                if (i == idx) digits[i] = builder.charAt(i) - '0' + 1;
                else if (i > idx) digits[i] = 0;
        } else { // 全為「9」的情況，位數改變，須建立新數列
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    private int lastIndexOfNotNineRegEx(String sourceStr) {
        int idx = -1;
        Matcher matcher = Pattern.compile("[0-8]").matcher(sourceStr);
        while (matcher.find()) idx = matcher.start();
        return idx;
    }
}

class PlusOneMathSimple {

    public int[] plusOne(int[] digits) {
        int digit = 0;

        // 第一階段：將「數列」轉換成「數值」
        for (int i = 0; i < digits.length; i++)
            digit += digits[i] * Math.pow(10, (digits.length - 1 - i));

        // 加一 && 判斷位數
        if ((int) Math.log10(++digit) + 1 == digits.length) {
            // 第二階段：將「數值」轉換回「數列」
            for (int i = 0; digit != 0; digit /= 10, i++) {
                int idx = digits.length - 1 - i;
                digits[idx] = digit % 10;
            }
        } else {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}

class PlusOneMath {
    public int[] plusOne(int[] digits) {

        BigInteger digit = BigInteger.ZERO;

        for (int i = 0; i < digits.length; i++)
            digit = digit.add(BigInteger.valueOf(digits[i]).multiply(BigDecimal.TEN.pow(digits.length - 1 - i).toBigInteger()));

        digit = digit.add(BigInteger.ONE);

        if (bigIntegerLog10(digit) == digits.length)
            for (int i = 0; i < digits.length; i++) {
                digits[digits.length - 1 - i] = digit.mod(BigInteger.TEN).intValue();
                digit = digit.divide(BigInteger.TEN);
            }
        else {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    private int bigIntegerLog10(BigInteger digit) {
        int digitSize = 0;
        for (; !digit.equals(BigInteger.ZERO); digitSize++)
            digit = digit.divide(BigInteger.TEN);
        return digitSize;
    }
}

class PlusOneOneByOnFromUnitsDigit {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--)
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else digits[i] = 0;
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
