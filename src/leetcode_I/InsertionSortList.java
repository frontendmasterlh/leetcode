package leetcode_I;

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		this.val = x;
		this.next = null;
	}
}

public class InsertionSortList {
    ListNode prehead;
    
    private ListNode findPos (ListNode target) {
        ListNode pre = prehead;
        ListNode cur = pre.next;
        while (cur != null && cur.val <= target.val) {
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
    
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        prehead = new ListNode (-1);
        ListNode cur = head, next = head.next;
        ListNode pos = null;
        while (cur != null) {
            pos = findPos (cur);
            next = cur.next;
            cur.next = pos.next;
            pos.next = cur;
            cur = next;
        }
        return prehead.next;
    }
    
    static public void main (String[] argv) {
    	ListNode r1 = new ListNode(1);
    	ListNode r2 = new ListNode(2);
    	ListNode r3 = new ListNode(3);
    	ListNode r4 = new ListNode(4);
    	ListNode r5 = new ListNode(5);
    	r3.next = r2;
    	r2.next = r5;
    	r5.next = r1;
    	r1.next = r4;
    	InsertionSortList is = new InsertionSortList();
    	ListNode res = is.insertionSortList(r3);
    	while (res != null) {
    		System.out.print(res.val +" ");
    		res = res.next;
    	}
    }
}
