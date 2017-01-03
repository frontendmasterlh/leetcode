package leetcode_P;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	};
}

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if (head==null)
            return null;
        ListNode prehead = new ListNode (x-1);
        prehead.next = head;
        ListNode cur = head;
        ListNode pre = prehead;
        while (cur!=null && cur.val < x){
            pre = cur;
            cur = cur.next;
        }
        if (cur!=null){
            ListNode pre2 = cur;
            ListNode cur2 = cur.next;
            while (cur2!=null) {
                if (cur2.val < x) {
                    pre.next = cur2;
                    pre2.next= cur2.next;
                    cur2.next = cur;
                    pre = pre.next;
                    cur2 = pre2.next;
                }else{
                    pre2 = cur2;
                    cur2 = cur2.next;
                }
            }
        }
        return prehead.next;
    }
	
	static public void main (String argv[]){
		;
	}
}
