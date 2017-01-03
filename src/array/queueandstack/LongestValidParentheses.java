package array.queueandstack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int accu = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (s.isEmpty()) {
                    accu = 0;
                } else {
                    Integer j = stack.pop();
                    if (stack.isEmpty()) {
                        accu = i - j + 1;
                        res = Math.max(res, accu);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
