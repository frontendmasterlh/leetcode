package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    public class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = next = null;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
            if (capacity < map.size()) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
        } else {
            removeNode(node);
            addToHead(node);
            node.value = value;
        }
    }

    private void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.pre = null;
        node.next = null;
    }

    private void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;
        next.pre = node;
        node.next = next;
    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache(1);
        l.set(2, 1);
        System.out.println(l.get(2));
        l.set(3, 2);
        System.out.println(l.get(2));
    }

}
