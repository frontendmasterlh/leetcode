package leetcode_R;

import java.util.*;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode (-1);
        dummy.next = head;
        ListNode pre = null;
        ListNode cur = dummy;
        int count=0;
        while (count < m){
            pre = cur;
            cur = cur.next;
            count++;
        }
        Stack<ListNode> stack = new Stack<ListNode> ();
        while (count < n){
            stack.push(cur);
            cur = cur.next;
            count++;
        }
        stack.push(cur);
        cur = cur.next;
        while (!stack.isEmpty()){
            ListNode temp = stack.pop();
            pre.next = temp;
            pre = pre.next;
        }
        pre.next = cur;
        return dummy.next;
    }
	
	static public void main (String[] argv){
		;
	}
}
