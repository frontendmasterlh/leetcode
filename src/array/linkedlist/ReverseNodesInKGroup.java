package array.linkedlist;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode (int x) {
            this.val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (head != null) {
            ListNode cur = head;
            for (int i = 1; cur != null && i < k; i++) { // Initialize i to one
                cur = cur.next;
            }
            if (cur == null) {
                tail.next = head;
                break;
            }
            ListNode temp = cur.next;
            cur.next = null;
            reverse(head);

            tail.next = cur;
            tail = head;
            head = temp;
        }
        return dummy.next;
    }

    private void reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
    }
}
