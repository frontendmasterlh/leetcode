package leetcode_S;

class ListNode {
	int val;
	ListNode next;
	ListNode (int x){
		val = x;
		next = null;
	};
}

public class SortList {
	public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode (-1);
        ListNode temp = dummy;
        while (left != null && right != null) {
            if (left.val > right.val) {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }else {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
        }
        if (left!= null){
            temp.next = left;
        }else
            temp.next = right;
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = null;
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            mid = slow;
            slow = slow.next;
        }
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        return merge (left, right);
    }
    
    static public void main (String[] argv){
    	;
    }
}
