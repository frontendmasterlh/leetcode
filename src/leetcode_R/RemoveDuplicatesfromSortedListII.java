package leetcode_R;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode prehead = new ListNode (-1);
        prehead.next = head;
        ListNode pre = prehead;
        ListNode cur;
        while (pre.next != null && pre.next.next != null){
            cur = pre.next.next;
            int move = 0;
            while (cur!=null && pre.next.val == cur.val){
                move = 1;
                cur = cur.next;
            }
            if (move==1)
                pre.next = cur;
            else{
                if (pre.next != null)//Consider whether it has next element or not.
                    pre = pre.next;
            }
        }
        return prehead.next;
    }
	
	static public void main (String[] argv){
		;
	}
}
