package leetcode_L;

import java.util.*;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s==null || s.length()==0)
            return 0;
        Stack<Integer> stack = new Stack<Integer> ();
        int count=0, topleft = 0;
        for (int i=0; i< s.length(); i++) {
            if (s.charAt(i)=='(') {
                stack.push(i);
            }else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        count = Math.max(count, i-stack.peek());
                    }else {
                        count = Math.max(count, i-topleft+1);
                    }
                }else
                    topleft = i +1;
            }
        }
        return count;
    }
    
    static public void main (String argv[]) {
    	String s = ")()())";
    	System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }
}
