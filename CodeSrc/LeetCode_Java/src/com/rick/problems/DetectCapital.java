package com.rick.problems;

public class DetectCapital {

    public static void main(String[] args) {
        String word = "fag";
        boolean res = new DetectCapital().detectCapitalUse(word);
        System.out.println(res);
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        boolean isFirstWordUpper = Character.isUpperCase(word.charAt(0));
        boolean isSecondWordUpper = Character.isUpperCase(word.charAt(1));

        // 如果 1st 是小寫、2nd 是大寫，不符合規定
        if (!isFirstWordUpper && isSecondWordUpper) return false;
        for (int i = 2; i < word.length(); i++) {
            // 如果第一個與第二個字元皆大寫
            if (isFirstWordUpper && isSecondWordUpper) {
                // 後續都要大寫
                if (Character.isLowerCase(word.charAt(i))) return false;
            } else { // 代表可能為第一個字元為大寫但第二個字元為小寫或第一個及第二個字元都小寫
                // 後續都要小寫
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }
}
