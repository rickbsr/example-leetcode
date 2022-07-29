package com.rick.problems;

public class ReverseStringII {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 3;
        String res = new ReverseStringII().reverseStr(s, k);
        System.out.println(res);
    }

    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
//            StringBuilder temp = new StringBuilder(s.substring(i, (s.length() - i > k) ? i + k : s.length()));
            StringBuilder temp = new StringBuilder(k);

            // 判斷這次循環要操作的字元
            if (s.length() - i > k) temp.append(s, i, i + k);
            else temp.append(s.substring(i));

//            res.append(((i / k) % 2 == 0) ? temp.reverse() : temp);
            // 判斷此次是否需要反轉
            if ((i / k) % 2 == 0) res.append(temp.reverse());
            else res.append(temp);
        }
        return res.toString();
    }
}
