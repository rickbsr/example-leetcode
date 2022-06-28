package com.rick.problems;

public class ShortestDistanceToACharacter {

    public static void main(String[] args) {
        String S = "xuzmnimdwf";
        char C = 'n';
        int[] res = new ShortestDistanceToACharacter().shortestToChar(S, C);
        for (int i : res) System.out.print(i + " ");
    }

    public int[] shortestToChar(String S, char C) {
        int len = S.length(), temp, res[] = new int[len], toRight[] = new int[len], toLeft[] = new int[len];
        temp = -len;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) temp = i;
            toRight[i] = i - temp;
        }


        temp = len * 2;
        for (int i = len - 1; i >= 0; i--) {
            if (S.charAt(i) == C) temp = i;
            toLeft[i] = temp - i;
        }
        for (int i = 0; i < len; i++) {
            res[i] = Math.min(toRight[i], toLeft[i]);
        }
        return res;
    }
}
