package leetcode_L;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private LRUNode head;
    private LRUNode tail;
    Map<Integer, LRUNode> map;
    private final int capacity;
    private int size;
    
    private class LRUNode {
        int key;
        int val;
        private LRUNode pre = null;
        private LRUNode next = null;
        
        private LRUNode (int k, int v) {
            this.key = k;
            this.val = v;
            this.pre = null;
            this.next = null;
        }
    }
    
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, LRUNode> ();
        this.capacity = capacity;
        this.head = new LRUNode (0,0);
        this.tail = new LRUNode (0,0);
        this.head.next = this.tail;
        this.tail.pre  = this.head;
    }
    
    public int get(int key) {
        LRUNode cur = map.get(key);
        if (cur==null)
            return -1;
        else {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            cur.pre = head;
            cur.next = head.next;
            head.next.pre = cur;
            head.next = cur;
            return cur.val;
        }
    }
    
    public void set(int key, int value) {
        LRUNode cur = map.get(key);
        if (cur==null) {
            LRUNode Nnode = new LRUNode (key, value);
            map.put(key, Nnode);
            Nnode.pre = head;
            Nnode.next = head.next;
            head.next.pre = Nnode;
            head.next = Nnode;
            size++;
            if (size > capacity) {
                map.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                size--;
            }
        }else {
            cur.val = value;
            map.put(key,cur);
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            cur.pre = head;
            cur.next = head.next;
            head.next.pre = cur;
            head.next = cur;            
        }
    }
    
    static public void main (String argv[]) {
    	;
    }
}
