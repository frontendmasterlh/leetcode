package leetcode_V;

import java.util.*;

public class ValidParentheses {
	public boolean isValid(String s) {
        if (s== null || s.length()==0)
            return true;
        if (s.length() %2 != 0)
            return false;
        int n = s.length();
        Stack<Character> stack = new Stack<Character> ();
        for (int i=0; i< n; i++) {
            if (s.charAt(i)=='(')
                stack.push(')');
            else if (s.charAt(i)=='{')
                stack.push('}');
            else if (s.charAt(i)=='[')
                stack.push(']');
            else if (stack.isEmpty() || s.charAt(i)!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();//At the end, remember check whether stack is empty or not.
    }
	static public void main (String[] argv){
		String s = "[]()[][][][]{}";
		System.out.println(new ValidParentheses().isValid(s));
	}
}
