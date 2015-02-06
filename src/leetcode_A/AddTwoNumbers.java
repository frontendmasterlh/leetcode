package leetcode_A;

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
		next = null;
	};
}

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        int carry = 0, temp = 0;
        ListNode dummy = new ListNode (-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null){
            int temp1 = 0;
            if (l1!=null){
                temp1 = l1.val;
                l1 = l1.next;
            }
            
            int temp2 = 0;
            if (l2!=null){
                temp2 = l2.val;
                l2 = l2.next;
            }
            temp = temp1 + temp2 + carry;//Don't forget to add the carry.
            carry = temp / 10;
            temp %= 10;
            ListNode newNode = new ListNode (temp);
            cur.next = newNode;
            cur = cur.next;
        }
        if (carry==1)
            cur.next = new ListNode (carry);
        return dummy.next;
    }
	
	static public void main (String[] argv){
		ListNode l1 = new ListNode (8);
		ListNode l2 = new ListNode (7);
		ListNode ret = new AddTwoNumbers().addTwoNumbers(l1, l2);
		while (ret !=null){
			System.out.println(ret.val);
			ret = ret.next;
		}
	}
}
