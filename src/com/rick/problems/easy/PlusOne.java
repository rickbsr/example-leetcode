package com.rick.problems.easy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.rick.constant.Constant.BLANK_STRING;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9}, res;

        res = new PlusOneStringRegEx().plusOne(digits);
        res = new PlusOneBruteForce().plusOne(digits);
        res = new PlusOneMath().plusOne(digits);

        for (int i : res) System.out.print(i + BLANK_STRING);
    }
}

/**
 * 方式一、字串轉換法
 */
class PlusOneStringRegEx {
    public int[] plusOne(int[] digits) {
        StringBuilder builder = new StringBuilder();
        for (int digit : digits) builder.append(digit);
        int idx = lastIndexOfNotNineRegEx(builder.toString());
        if (idx != -1) {
            char[] digitsChars = builder.toString().toCharArray();
            digitsChars[idx]++;
            for (int i = 0; i < digits.length; i++) digits[i] = i > idx ? 0 : digitsChars[i] - '0';
        } else {
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

/**
 * 方式二、暴力演算法
 */
class PlusOneBruteForce {
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

/**
 * 方式三、數學運算法
 */
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
