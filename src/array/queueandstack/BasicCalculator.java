package array.queueandstack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 */
public class BasicCalculator {
    public int calculate(String s) {
        s = s.replace(" ", "");
        // Stack is used to store the bracket with the '+'/'-' sign, not the actual numbers
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        int i = 0, res = 0, sign = 1;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '+') {
                sign = 1;
                i++;
            } else if (c == '-') {
                sign = -1;
                i++;
            } else if (c == '(') {
                stack.push(sign * stack.peek());
                sign = 1;
                i++;
            } else if (c == ')') {
                stack.pop();
                i++;
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += num * sign * stack.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BasicCalculator b = new BasicCalculator();
        System.out.println(b.calculate("6 + (2 - 5)"));
    }
}
