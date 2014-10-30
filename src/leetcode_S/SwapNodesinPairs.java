package leetcode_S;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode (0);
        ListNode pre = dummy;
        ListNode next = head.next;
        while (head != null && next != null){
            pre.next = next;
            head.next = next.next;
            next.next = head;
            pre = head;
            if (head.next == null)// Guarantee that the next elem of head is null. 
                break;
            head = head.next;
            next = head.next;
        }
        return dummy.next;
    }
	
	static void main (String[] argv){
		;
	}
}
