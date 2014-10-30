package leetcode_R;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head==null || head.next==null || n <= 0)
            return head;
        ListNode dummy = new ListNode (-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int num = 0;
        while (cur!=null){
            num++;//count the num of the elem.
            pre = cur;
            cur = cur.next;
        }
        n = n % num;
        int count = 0;
        cur = dummy;
        while (count < num - n){//Points to the pre elem of the new start elem.
            cur = cur.next;
            count++;
        }
        pre.next = dummy.next;
        dummy.next = cur.next;
        cur.next = null;
        
        return dummy.next;
    }
    
    static public void main (String[] argv){
    	;
    }
}
