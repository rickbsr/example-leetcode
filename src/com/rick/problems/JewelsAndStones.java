package com.rick.problems;

public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        int res = new JewelsAndStones().numJewelsInStones(J, S);
        System.out.println(res);
    }

    public int numJewelsInStones(String J, String S) {

        int count = 0;
        for (char c : S.toCharArray()) {
            // 若 J 字串中有包含 S 字串的字元，則計數加 1
            if (J.contains(String.valueOf(c))) count++;
        }
        return count;
    }
}
