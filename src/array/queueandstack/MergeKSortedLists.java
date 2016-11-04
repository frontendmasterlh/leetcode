package array.queueandstack;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode (int x) {
            this.val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode dummy = new ListNode (-1);
        ListNode pre = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val < o2.val ? -1 : 1;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {  // Note: ListNode may be null!
                pq.offer(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
