package com.rick.problems;

public class OneBitAndTwoBitCharacters {

    public static void main(String[] args) {
        int[] bits = {0, 0, 0};
        boolean res = new OneBitAndTwoBitCharacters().isOneBitCharacter(bits);
        System.out.println(res);
    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 2) {
            // 代表 2-bit，移兩位
            if (bits[i] == 1) i += 2;
            else i++; // 代表 1-bit，移一位
        }
        return bits[i] == 0;
    }
}
