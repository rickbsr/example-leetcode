package com.rick.problems.easy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3}, res;

        res = new PlusOneOneByOnFromUnitsDigit().plusOne(digits);

        res = new PlusOneString().plusOne(digits);

        res = new PlusOneMath().plusOne(digits);

        for (int i : res) System.out.print(i + " ");
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

class PlusOneString {

    public int[] plusOne(int[] digits) {

        StringBuilder builder = new StringBuilder();

        for (int digit : digits) builder.append(digit);

        String digitStr = new BigInteger(builder.toString()).add(BigInteger.ONE).toString();

        if (digitStr.length() == digits.length)
            for (int i = 0; i < digits.length; i++)
                digits[i] = Integer.parseInt(String.valueOf(digitStr.charAt(i)));
        else {
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

        if (getBigIntegerNumLength(digit) == digits.length)
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

    private int getBigIntegerNumLength(BigInteger digit) {
        int digitSize = 0;

        for (; !digit.equals(BigInteger.ZERO); digitSize++)
            digit = digit.divide(BigInteger.TEN);

        return digitSize;
    }
}

