package leetcode_E;

import java.util.*;

public class EvaluateReversePolishNotation {
	Stack<Integer> stack;
    
    private void store (String s) {
        int temp = 0;
        for (int i=0; i< s.length(); i++){
            if (i==0 && s.charAt(i)=='-')
                continue;
            temp = temp * 10 + s.charAt(i) - '0';
        }
        if (s.charAt(0)=='-')
            temp = -temp;
        System.out.println(temp);
        stack.push(temp);
    }
    
    public int evalRPN(String[] tokens) {
        int res = 0;
        int n = tokens.length;
        if (n==0)
            return res;
        stack = new Stack<Integer> ();
        
        for (int i =0; i< n; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                store(tokens[i]);
            }else {
                int two = stack.pop();
                int one = stack.pop();
                if (tokens[i].equals("+"))
                    stack.push(one + two);
                else if (tokens[i].equals("-"))
                    stack.push(one - two);
                else if (tokens[i].equals("*"))
                    stack.push(one * two);
                else 
                    stack.push(one / two);
            }
        }
        return stack.pop();
    }
    
    static public void main (String[] argv) {
    	String[] tokens = {"1","3", "+"};
    	
    	EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
    	System.out.println(e.evalRPN(tokens));
    }
}
