package leetcode_L;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        if (head==null)
            return null;
        ListNode fast = head;
        ListNode slow  = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                break;
            }
        }
        if (fast==null || fast.next==null)
            return null;
        else {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
	
	static public void main (String argv[]){
		;
	}
}
