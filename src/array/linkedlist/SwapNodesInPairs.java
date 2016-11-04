package array.linkedlist;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode (int x) {
            this.val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode pre2 = head.next;
        while (pre2 != null) {
            ListNode cur = pre.next;
            ListNode next = pre2.next;
            pre.next = cur.next;
            cur.next = next;
            pre.next.next = cur;
            pre = cur;
            if (pre.next == null || pre.next.next == null) {
                break;
            }
            pre2 = pre.next.next;
        }
        return dummy.next;
    }
}
