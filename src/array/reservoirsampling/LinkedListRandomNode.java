package array.reservoirsampling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 */
public class LinkedListRandomNode {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    List<ListNode> list;
    Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        list = new ArrayList<>();
        random = new Random();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        return list.get(random.nextInt(list.size())).val;
    }

    ListNode head;

//    /** @param head The linked list's head.
//    Note that the head is guaranteed to be not null, so it contains at least one node. */
//    public LinkedListRandomNode(ListNode head) {
//        this.head = head;
//        this.random = new Random();
//    }
//
//    /** Returns a random node's value. */
//    public int getRandomWithLinkedList() {
//        ListNode cur = head;
//        int res = cur.val;
//        for (int n = 1; cur != null; n++) {
//            if (random.nextInt(n) == 0) {
//                res = cur.val;
//            }
//            cur = cur.next;
//        }
//        return res;
//    }
}
