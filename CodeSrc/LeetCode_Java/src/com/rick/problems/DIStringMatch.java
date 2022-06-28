package com.rick.problems;

public class DIStringMatch {

    public static void main(String[] args) {
        String S = "DDI";
        int[] res = new DIStringMatch().diStringMatch(S);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] diStringMatch(String S) {

        // 返回陣列的長度為 n + 1
        int[] res = new int[S.length() + 1];
        int s = 0, e = S.length(); // 第一項與最末項
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') res[i] = s++;
            else res[i] = e--;
        }
        // 記得要填最後一項
        res[S.length()] = s;

        return res;
    }
}
