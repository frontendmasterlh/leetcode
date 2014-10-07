package leetcode_M;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class MergeTwoSortedLists {
	private static ListNode list1 = null;
	private static ListNode list2 = new ListNode(1);
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null)
            return null;
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        ListNode head = new ListNode (-1);
        ListNode pre = head;
        while (l1!=null && l2!=null){
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            }else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        if (l1==null){
            if (l2!=null)
                pre.next = l2;
        }else  if (l2==null)
            if (l1 != null)
                pre.next = l1;
        return head.next;
    }
	
	static public void main (String argv[]) {
		System.out.println(new MergeTwoSortedLists().mergeTwoLists(list1, list2));
	}
}
