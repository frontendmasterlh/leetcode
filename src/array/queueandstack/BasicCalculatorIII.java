package array.queueandstack;

import java.util.Stack;

/**
 * Created by jli1 on 11/29/16.
 */
public class BasicCalculatorIII {

    public int calculate(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        Stack<Integer> valStack = new Stack<>();
        Stack<String> opStack = new Stack<>();
        for (int i = 0; i <= strs.length; i++) {
            if (i < strs.length && (strs[i].length() > 1 || Character.isDigit(strs[i].charAt(0)))) {
                valStack.push(Integer.parseInt(strs[i]));
            } else if (i == strs.length || !strs[i].equals("(")) {
                while (!opStack.isEmpty() && !opStack.peek().equals("(") && (i == strs.length || isOk(opStack.peek(), strs[i]))) {
                    int temp = valStack.pop();
                    valStack.push(calculate(valStack.pop(), temp, opStack.pop()));
                }
                if (i == strs.length) {
                    break;
                } else if (strs[i].equals(")")) {
                    opStack.pop(); // "("
                } else { // Add +,-,*,/
                    opStack.push(strs[i]);
                }
            } else { // Add (
                opStack.push(strs[i]);
            }
        }
        return valStack.pop();
    }

    private boolean isOk(String op1, String op2) {
        if (op1.equals("*") || op1.equals("/") || op2.equals(")")) {
            return true;
        } else {
            return op2.equals("+") || op2.equals("-");
        }
    }

    private int calculate(int num1, int num2, String op) {
        if (op.equals("+")) {
            return num1 + num2;
        } else if (op.equals("-")) {
            return num1 - num2;
        } else if (op.equals("*")) {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    public static void main(String[] args) {
        BasicCalculatorIII b = new BasicCalculatorIII();
        String[] strs = {"2", "*", "6", "-", "(",
                         "23", "+", "7", ")", "/",
                         "(", "1", "+", "2", ")"};
        System.out.println(b.calculate(strs));
    }
}
