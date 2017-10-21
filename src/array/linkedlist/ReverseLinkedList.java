package array.linkedlist;

/**
 * Created by jli1 on 11/8/16.
 */
public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode (int x) {
            this.val = x;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public ListNode reverseWithRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        head.next = null;

        ListNode newHead = reverseWithRecursion(second);
        second.next = head;
        return newHead;
    }

    public ListNode reverseTailRecursion(ListNode head) {
        if (head == null) {
            return head;
        }
        return tailRecursion(null, head);
    }

    private ListNode tailRecursion(ListNode pre, ListNode cur) {
        if (cur.next == null) {
            cur.next = pre;
            return cur;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return tailRecursion(cur, next);
    }

    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        ListNode res = r.reverseWithRecursion(head);
//        for (ListNode cur = res; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }

        ListNode res = r.reverseTailRecursion(head);
        for (ListNode cur = res; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}
