package com.rick.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses {

    public static void main(String[] args) {
        String S = "((())())";
        int res = new ScoreOfParentheses().scoreOfParentheses(S);
        System.out.println(res);
    }

    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (c == '(') stack.push(-1);
            else {
                if (stack.peek() == -1) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int sum = 0;
                    while (stack.peek() != -1) sum += stack.pop();
                    stack.pop();
                    stack.push(2 * sum);
                }
            }
        }
        int ans = 0;
        while (stack.size() > 0) ans += stack.pop();
        return ans;
    }
}
