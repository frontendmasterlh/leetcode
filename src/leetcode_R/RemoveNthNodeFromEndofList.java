package leetcode_R;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode slow = head;
        ListNode fast = head;
        for (int i=0; i< n; i++){
            if (fast.next == null){//Has reached the end, delete the head.
                return head.next;
            }
            fast = fast.next;
        }
        
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return prehead.next;
    }
	
	static public void main (String[] argv){
		;
	}
}
