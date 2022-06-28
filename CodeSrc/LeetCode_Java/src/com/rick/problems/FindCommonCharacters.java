package com.rick.problems;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public static void main(String[] args) {
        String[] A = {"cool", "lock", "cook"};
        List<String> res = new FindCommonCharacters().commonChars(A);
        for (String str : res) System.out.print(str + " ");
    }

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int resArr[] = new int[26], countArr[] = new int[26], round = 0;
        for (String s : A) {
            for (char c : s.toCharArray()) ++countArr[c - 'a'];
            for (int i = 0; i < 26; i++) {
                if (round == 0) resArr[i] = countArr[i];
                else if (resArr[i] != 0) resArr[i] = Math.min(resArr[i], countArr[i]);
                countArr[i] = 0;
            }
            round++;
        }
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < resArr[i]; j++)
                res.add(String.valueOf((char) (i + 'a')));
        return res;
    }
}
