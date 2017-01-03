package array.hashtable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache {

    public class Node {
        int key;
        int val;
        int fre;
        Node pre;
        Node next;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
            this.fre = 1;
            this.pre = this.next = null;
        }
    }

    PriorityQueue<Node> f;
    Map<Integer, Node> map;
    int capacity;
    int size;
    Node head;
    Node tail;

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.f = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                if (o1.fre == o2.fre) {
                    return 0;
                } else {
                    return o1.fre < o2.fre ? -1 : 1;
                }
            }
        });
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre  = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node cur = map.get(key);
//            f.remove(cur);
//            cur.fre = cur.fre + 1;
//            f.add(cur);
            removeNode(cur);
            cur.fre = cur.fre + 1;
            putToFirst(cur);
            return cur.val;
        }
    }

    public void set(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!map.containsKey(key)) {
            if (size == capacity) {

//                Node top = f.poll();
                Node last = tail.pre;
                removeNode(tail.pre);
                map.remove(last.key);
                size--;
            }
            Node cur = new Node(key, value);
            putToFirst(cur);
            size++;
//            f.offer(cur);
            map.put(key, cur);
        } else {
            Node cur = map.get(key);
            removeNode(cur);
//            f.remove(cur);
            cur.val = value;
            cur.fre = cur.fre + 1;
            putToFirst(cur);
//            f.add(cur);
        }
    }

    private void removeNode(Node cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        cur.pre = null;
        cur.next = null;
    }

    private void putToFirst(Node cur) {
        Node next = head.next;
        cur.next = next;
        cur.pre = head;
        head.next = cur;
        next.pre = cur;
    }

    public static void main(String[] args) {
        LFUCache l = new LFUCache(3);
//        l.set(0,0);
//        System.out.println(l.get(0));

//        l.set(2,1);
//        l.set(1,1);
//        l.set(2,3);
//        l.set(4,1);
//        System.out.println(l.get(1));
//        System.out.println(l.get(2));

        l.set(1,1);
        l.set(2,2);
        l.set(3,3);
        l.set(4,4);

        System.out.println(l.get(4));
        System.out.println(l.get(3));
        System.out.println(l.get(2));
        System.out.println(l.get(1));

        l.set(5, 5);
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
        System.out.println(l.get(5));

    }
}
