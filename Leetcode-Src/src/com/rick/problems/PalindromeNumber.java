package com.rick.problems;

public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        boolean res = new PalindromeNumber().isPalindrome(x);
        System.out.println(res);
    }

    public boolean isPalindrome(int x) {

        // 如果 x < 0 就 return false
        if (x < 0) return false;

        // 將 x 轉為 String
        String str = String.valueOf(x);

        // 若長度小於 2，則代表可能為空字串或單字
        while (str.length() >= 2) {

            // 判斷字串的第一個是否等於最後一個，沒有則 return false
            if (str.charAt(0) != str.charAt(str.length() - 1)) return false;

            // 取去掉頭尾的字串
            str = str.substring(1, str.length() - 1);
        }
        return true;
    }
}
