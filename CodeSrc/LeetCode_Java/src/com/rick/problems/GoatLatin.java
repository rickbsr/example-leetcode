package com.rick.problems;

public class GoatLatin {
    public static void main(String[] args) {
        String S = "The quick brown fox jumped over the lazy dog";
        String res = new GoatLatin().toGoatLatin(S);
        System.out.println(res);
    }

    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (String str : S.split(" ")) sb.append(toGoatLatinWord(str, i++)).append(" ");
        return sb.toString();
    }

    private String toGoatLatinWord(String word, int count) {
        StringBuilder sb = new StringBuilder(word);
        switch (word.charAt(0)) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                break;
            default:
                sb.deleteCharAt(0).append(word.charAt(0));
                break;
        }
        sb.append("ma");
        for (int i = 0; i < count; i++) sb.append('a');
        return sb.toString();
    }
}
