package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/all-oone-data-structure/
 */
public class AllOOneDataStructure {
    public class Node {
        String key;
        int val;
        Node pre;
        Node next;
        public Node(String key, int val) {
            this.key = key;
            this.val = val;
            pre = next = null;
        }
    }

    private Node head;
    private Node tail;
    private Map<String, Node> map;

    /** Initialize your data structure here. */
    public AllOOneDataStructure() {
        map = new HashMap<>();
        head = new Node("", Integer.MAX_VALUE);
        tail = new Node("", Integer.MIN_VALUE);
        head.next = tail;
        tail.pre = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node cur = map.get(key);
        if (cur == null) {
            cur = new Node(key, 1);
            map.put(key, cur);
            addToTail(cur);
        } else {
            cur.val++;
            if (cur.val >= head.next.val) {
                remove(cur);
                addToHead(cur);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.get(key) == null) {
            return;
        }
        Node cur = map.get(key);
        if (cur.val == 1) {
            map.remove(key);
            remove(cur);
        } else {
            cur.val--;
            if (cur.val <= tail.pre.val) {
                remove(cur);
                addToTail(cur);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return head.next.key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return tail.pre.key;
    }

    private void remove(Node cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        cur.next = null;
        cur.pre = null;
    }

    private void addToHead(Node cur) {
        Node next = head.next;
        head.next = cur;
        next.pre = cur;
        cur.next = next;
        cur.pre = head;
    }

    private void addToTail(Node cur) {
        Node pre = tail.pre;
        pre.next = cur;
        tail.pre = cur;
        cur.next = tail;
        cur.pre = pre;
    }

    /*
    *
    *
    * ["AllOne","inc","inc","inc","inc","inc","inc","getMaxKey","inc","dec","getMaxKey","dec","inc","getMaxKey","inc","inc","dec","dec","dec","dec","getMaxKey","inc","inc","inc","inc","inc","inc","getMaxKey","getMinKey"]
[[],["hello"],["world"],["leet"],["code"],["DS"],["leet"],[],["DS"],["leet"],[],["DS"],["hello"],[],["hello"],["hello"],["world"],["leet"],["code"],["DS"],[],["new"],["new"],["new"],["new"],["new"],["new"],[],[]]
    *
    * */

    public static void main(String[] args) {
        AllOOneDataStructure a = new AllOOneDataStructure();
        a.inc("Hello");
        a.inc("World");
        a.inc("Leet");
        a.inc("Code");
        a.inc("DS");
        a.inc("Leet");
        System.out.println(a.getMaxKey());
        a.inc("DS");
        a.dec("Leet");
        System.out.println(a.getMaxKey());
        a.dec("DS");
        a.inc("Hello");
        System.out.println(a.getMaxKey());
        a.inc("Hello");
        a.inc("Hello");
        a.dec("World");
        a.dec("Leet");
        a.dec("Code");
        a.dec("DS");
        System.out.println(a.getMaxKey());
        a.inc("New");
        a.inc("New");
        a.inc("New");
        a.inc("New");
        a.inc("New");
        a.inc("New");
        System.out.println(a.getMaxKey());
        System.out.println(a.getMinKey());

//        a.inc("a");
//        a.inc("a");
//        a.inc("a");
//        a.inc("a");
//        a.inc("a");
//        a.inc("a");
//        a.inc("a");
//        a.inc("a");
//        a.inc("b");
//        a.inc("b");
//        a.inc("c");
//        a.dec("c");
//        System.out.println(a.getMinKey());

    }
}
