package leetcode_L;
class ListNode {
	int val;
	ListNode next;
	ListNode (int x) { 
		val = x;
		next = null;
	};
}
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head==null)
            return false;
        ListNode fast = head;
        ListNode low = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            low = low.next;
            if (fast== low)
                return true;
        }
        return false;
    }
	
	static public void main (String argv[]){
		;
	}
}
