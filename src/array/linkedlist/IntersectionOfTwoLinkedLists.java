package array.linkedlist;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode (int x) {
            this.val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // // Method 1: Traverse two lists
        // if (headA == null || headB == null) {
        //     return null;
        // }
        // ListNode lastA = headA;
        // ListNode lastB = headB;
        // int countA = 0, countB = 0;
        // while (lastA.next != null) {
        //     lastA = lastA.next;
        //     countA++;
        // }
        // while (lastB.next != null) {
        //     lastB = lastB.next;
        //     countB++;
        // }
        // if (lastA != lastB) {
        //     return null;
        // }
        // while (countA > countB) {
        //     headA = headA.next;
        //     countA--;
        // }
        // while (countB > countA) {
        //     headB = headB.next;
        //     countB--;
        // }
        // while (headA != headB) {
        //     headA = headA.next;
        //     headB = headB.next;
        // }
        // return headA;

        // Method 2: find cycle
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;
        ListNode res = findCycle(headA);
        node.next = null;
        return res;
    }

    private ListNode findCycle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
