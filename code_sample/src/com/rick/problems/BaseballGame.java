package com.rick.problems;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int res = new BaseballGame().calPoints(ops);
        System.out.println(res);
    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String s : ops) {
            switch (s) {
                case "C":
                    sum -= stack.pop();
                    break;
                case "D":
                    int doubledValue = 2 * stack.peek();
                    stack.push(doubledValue);
                    sum += doubledValue;
                    break;
                case "+":
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second);
                    stack.push(first);
                    stack.push(first + second);
                    sum += (first + second);
                    break;
                default:
                    int val = Integer.valueOf(s);
                    sum += val;
                    stack.push(val);
            }
        }
        return sum;
    }
}
