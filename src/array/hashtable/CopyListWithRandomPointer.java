package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {
    public class RandomListNode {
        int label;
        RandomListNode next, random;

        public RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newRandomListNode = new RandomListNode(cur.label);
            map.put(cur, newRandomListNode);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode newRandomListNode = map.get(cur);
            newRandomListNode.next = map.get(cur.next);
            newRandomListNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
