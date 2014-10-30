package leetcode_R;

class ListNode {
	int val;
	ListNode next;
	ListNode (int x){
		val = x;
		next = null;
	};
}

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return null;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur!=null){
            if (cur.val != pre.val){
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;//prevent it has duplicate element at the end.
        return head;
    }
	
	static public void main (String[] argv) {
		;
	}
}
