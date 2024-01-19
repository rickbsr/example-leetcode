package com.rick.problems;

public class RemoveOutermostParentheses {

    public static void main(String[] args) {
        String S = "(()())(())";
        String res = new RemoveOutermostParentheses().removeOuterParentheses(S);
        System.out.println(res);
    }

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (count != 0 && c == '(') sb.append('(');
            count += (c == '(' ? 1 : -1);
            if (count != 0 && c == ')') sb.append(')');
        }
        return sb.toString();
    }
}
