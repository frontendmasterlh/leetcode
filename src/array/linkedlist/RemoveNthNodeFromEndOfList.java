package array.linkedlist;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode (int x) {
            this.val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next= head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return dummy.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
