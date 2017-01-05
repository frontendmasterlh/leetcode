package array.maths;

/**
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3

 Output:
 1->2->4
 */
public class PlusOneLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode (int x) {
            this.val = x;
        }
    }

    public ListNode plusOne(ListNode head) {
        ListNode newHead = reverse(head);
        ListNode cur = newHead;
        cur.val += 1;
        while (cur != null && cur.val > 9) {
            cur.val %= 10;
            if (cur.next != null) {
                cur.next.val += 1;
            } else {
                cur.next = new ListNode(1);
            }
            cur = cur.next;
        }
        return reverse(newHead);
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    private ListNode reverseWithIteration(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = null;

        ListNode newHead = reverseWithIteration(temp);
        temp.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        PlusOneLinkedList p = new PlusOneLinkedList();
        ListNode root = new ListNode(9);
        root.next = new ListNode(9);
        ListNode res = p.plusOne(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
