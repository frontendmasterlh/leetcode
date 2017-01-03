package leetcode_L;

public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode h1 = headA;
        ListNode h2 = headB;
        int lenA = 1;
        while (h1.next != null){
            lenA++;
            h1 = h1.next;
        }
        
        int lenB = 1;
        while (h2.next != null){
            lenB++;
            h2 = h2.next;
        }
        
        if (h1 != h2)
            return null;
        
        int diff = lenA - lenB;
        if (diff >= 0){
            h1 = headA;
            h2 = headB;
            while (diff > 0) {
                diff--;
                h1 = h1.next;
            }
        }else if (diff < 0){
            h1 = headB;
            h2 = headA;
            while (diff < 0){
                diff++;
                h1 = h1.next;
            }
        }
        
        while (h1 != null && h2 != null && h1 != h2){
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }
	
	static public void main (String[] argv) {
		;
	}
}
