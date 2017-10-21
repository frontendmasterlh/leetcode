package array.queueandstack;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
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

    public ListNode mergeKListsWithMergeSort(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = partition(lists, start, mid);
        ListNode right = partition(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry entry : map.entrySet()) {
            pq.offer(entry);
        }
        System.out.println(pq.peek().getKey() + " " + pq.peek().getValue());
        map.put(2, 0);
        System.out.println(pq.peek().getKey() + " " + pq.peek().getValue()); // This shows that when entry's value has changed, the pq will not know.
        pq.poll();
        System.out.println(pq.peek().getKey() + " " + pq.peek().getValue());
    }
}
