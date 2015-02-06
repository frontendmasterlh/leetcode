package leetcode_C;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode (int x) {
		this.label = x;
		this.next = null;
		this.random = null;
	}
}

public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode cur = head, cur2 = null;
        RandomListNode newhead = head;
        while (cur != null){
            RandomListNode temp = new RandomListNode (cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = head;
        while (cur != null){
            cur.next.random = cur.random== null ? null : cur.random.next;
            cur = cur.next.next;
        }
        
        cur = head;
        newhead = cur.next;
        cur2 = newhead;
        while (cur != null){
            cur.next = cur2.next;
            cur = cur.next;
            if (cur == null)
                break;
            cur2.next = cur.next;
            cur2 = cur2.next;
        }
        return newhead;
    }
	
	static public void main (String[] argv) {
		;
	}
}
