package com.rick.problems;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String S = "abbaca";
        String res = new RemoveAllAdjacentDuplicatesInString().removeDuplicates(S);
        System.out.println(res);
    }

    public String removeDuplicates(String S) {
        for (int i = 0; i < S.length() - 1; i++)
            if (S.charAt(i) == S.charAt(i + 1))
                return removeDuplicates(S.substring(0, i).concat(S.substring(i + 2)));
        return S;
    }
}
