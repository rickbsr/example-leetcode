package com.rick.problems;

public class LargestTimeForGivenDigits {

    public static void main(String[] args) {
        int[] A = {1, 1, 5, 0};
        String res = new LargestTimeForGivenDigits().largestTimeFromDigits(A);
        System.out.println(res);
    }

    public String largestTimeFromDigits(int[] A) {
        boolean hasDigitInOnes, hasDigitInTens;

        for (int h = 23; h >= 0; h--) {
            hasDigitInOnes = false;
            hasDigitInTens = false;
            StringBuilder sb = new StringBuilder();

            for (int i : A) {
                // 判斷小時的個位數
                if (!hasDigitInOnes && (i == h / 10)) {
                    hasDigitInOnes = !hasDigitInOnes;
                    continue;
                }

                // 判斷小時的十位數
                if (!hasDigitInTens && (i == h % 10)) {
                    hasDigitInTens = !hasDigitInTens;
                    continue;
                }

                // 剩餘的數
                sb.append(i);
            }

            // 數組含有小時所需的整數才繼續判斷分鐘
            if (!hasDigitInOnes || !hasDigitInTens) continue;

            // 分鐘可能的組合
            int m1 = Integer.parseInt(sb.toString());
            int m2 = Integer.parseInt(sb.reverse().toString());

            // 判斷分鐘是否合法
            if (Math.min(m1, m2) < 60)
                return String.format("%02d:%02d", h,
                        (Math.max(m1, m2) < 60) ? Math.max(m1, m2) : Math.min(m1, m2));
        }
        return "";
    }
}
