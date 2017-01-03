package array.queueandstack;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Example:
    "3+2*2" = 7
    " 3/2 " = 1
    " 3+5 / 2 " = 5
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Long> stack = new Stack<>();
        String firstNum = getNum(0, s);
        stack.push(Long.parseLong(firstNum));
        int i = firstNum.length();
        while (i < s.length()) {
            char c = s.charAt(i);
            String nextNum = getNum(i + 1, s);
            if (c == '+') {
                stack.push(Long.parseLong(nextNum));
            } else if (c == '-') {
                stack.push(-Long.parseLong(nextNum));
            } else if (c == '*') {
                stack.push(stack.pop() * Long.parseLong(nextNum));
            } else if (c == '/') {
                stack.push(stack.pop() / Long.parseLong(nextNum));
            }
            i = i + nextNum.length() + 1;
        }
        long res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return (int) res;
    }

    private String getNum(int i, String s) {
        StringBuilder sb = new StringBuilder();
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BasicCalculatorII b = new BasicCalculatorII();
        System.out.println(b.calculate("2 - 7 * 3"));
    }
}
