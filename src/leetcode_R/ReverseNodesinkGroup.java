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
    
    static public void main (String[] argv){
    	;
    }
}
