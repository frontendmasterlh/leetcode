package array.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * 2 solutions: http://www.cnblogs.com/grandyang/p/4568796.html
 */
public class ImplementStackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        q2.offer(x);
        while (q2.size() > 1) {
            q1.offer(q2.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        top();
        q2.poll();
    }

    // Get the top element.
    public int top() {
        if (q2.isEmpty()) {
            for (int i = 0; i < q1.size() - 1; i++) {
                q1.offer(q1.poll());
            }
            q2.offer(q1.poll());
        }
        return q2.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
