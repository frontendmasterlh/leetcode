package leetcode_R;

public class ReverseNodesinkGroup {
    private ListNode reverse_range(ListNode pre,  ListNode end){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != end) {//Put the next elem to pre's next so that 1234 can change into 4321.
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            //pre = cur;
            cur = last.next;
        }
        return last;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || k <= 1)
            return head;
        ListNode dummy = new ListNode (-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        int count = 1;
        //Stack<ListNode> stack = new Stack<ListNode> ();
        while (cur != null){
            if (count %k == 0){
                pre = reverse_range(pre, cur.next);//Remember to return the last value as pre.
                cur = pre.next;
            }
            else{
                cur = cur.next;
            }
            count++;
        }
        return dummy.next;
    }
    
    private void reverse (ListNode head) {
        ListNode newhead = null;
        while (head != null) {
        	//System.out.println(head.val + ".");
            ListNode tmp = head.next;
            head.next = newhead;
            newhead = head;
            head = tmp;
        }
    }
    
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;
        ListNode dummy = new ListNode (-1);
        ListNode tail = dummy;
        while (head != null) {
            ListNode cur = head;
            for (int i = 1; i< k && cur != null; i++) {
                cur = cur.next;
            }
            if (cur==null){
                tail.next = head;
                break;
            }
            ListNode tmp = cur.next;
            cur.next = null;
            reverse(head);
            
            //System.out.println(head.val);
            tail.next = cur;
            tail = head;  //Note: This head doesn't been changed.
            head = tmp;
        }
        return dummy.next;
    }
    
    static public void main (String[] argv){
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	head.next.next.next.next.next = new ListNode(6);
    	
    	ReverseNodesinkGroup r = new ReverseNodesinkGroup();
    	r.reverseKGroup2(head, 2);
    }
}
