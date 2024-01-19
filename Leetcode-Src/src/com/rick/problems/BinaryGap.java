package com.rick.problems;

public class BinaryGap {

    public static void main(String[] args) {
        int N = 22;
        int res = new BinaryGap().binaryGap(N);
        System.out.println(res);
    }

    public int binaryGap(int N) {
        String binaryStr = Integer.toBinaryString(N);
        int res = 0, idx = 0;
        boolean hasOne = false;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                if (hasOne) {
                    int diff = i - idx;
                    res = Math.max(res, diff);
                } else hasOne = true;
                idx = i;
            }
        }
        return res;
    }
}
