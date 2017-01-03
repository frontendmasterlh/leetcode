package array.queueandstack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() > 1 || Character.isDigit(tokens[i].charAt(0))) { // The str may be `-4`
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            } else {
                int second = stack.pop();
                int first = stack.pop();
                char c = tokens[i].charAt(0);
                if (c == '+') {
                    stack.push(first + second);
                } else if (c == '-') {
                    stack.push(first - second);
                } else if (c == '*') {
                    stack.push(first * second);
                } else {
                    stack.push(first / second);
                }
            }
        }
        return stack.peek();
    }
}
