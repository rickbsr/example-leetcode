package com.rick.problems;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()";
        boolean res = new ValidParentheses().isValid(s);
        System.out.println(res);
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
