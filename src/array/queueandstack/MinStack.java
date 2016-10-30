package array.queueandstack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if ((!min.isEmpty()) && min.peek() < x) {
            min.push(min.peek());
        } else {
            min.push(x);
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
