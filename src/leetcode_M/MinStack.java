package leetcode_M;

import java.util.*;

public class MinStack {
	private Stack<Integer> stack = new Stack<Integer>(); 
    
    private Stack<Integer> minstack = new Stack<Integer> ();//The idea is to provide an additional stack
    
    public void push(int x) {
        if (minstack.isEmpty() || minstack.peek() >= x)
            minstack.push(x);
        stack.push(x);
    }

    public void pop() {
        if (!minstack.isEmpty() && minstack.peek().equals(stack.peek()))
            minstack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
    
    static public void main (String[] argv) {
    	MinStack ms = new MinStack();
    	ms.push(5);
    	ms.push(8);
    	ms.push(3);
    	ms.push(6);
    	System.out.println(ms.top());
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.top());
    	
    }
}
