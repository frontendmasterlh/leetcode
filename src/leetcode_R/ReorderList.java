package leetcode_R;

import java.util.*;

public class ReorderList {
	public void reorderList(ListNode head) {
        if (head==null || head.next==null)
            return ;
        // ListNode dummy = new ListNode (-1);
        // dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        Stack<ListNode> stack = new Stack<ListNode> ();//use stack to reverse the sequence of the 2nd list
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        
        cur = head;
        while (!stack.isEmpty()){
            ListNode temp = stack.pop();
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
    }
	
	static public void main (String[] argv){
		;
	}
}
