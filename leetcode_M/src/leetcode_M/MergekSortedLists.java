package leetcode_M;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MergekSortedLists {
	private class ListNodeComparator implements Comparator<ListNode> {
        public int compare (ListNode o1, ListNode o2) {
            if (o1.val < o2.val)
                return -1;
            else if (o1.val > o2.val)
                return 1;
            else 
                return 0;
        }
    }
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists==null || lists.size()==0)
            return null;
        ListNode head = new ListNode (-1);
        ListNode pre = head;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode> (lists.size(), new Comparator<ListNode> (){
            public int compare (ListNode o1, ListNode o2) {
            if (o1.val < o2.val)
                return -1;
            else if (o1.val > o2.val)
                return 1;
            else 
                return 0;
            }
        });
        for (ListNode list : lists) {
            if (list!=null)//即使ArrayList的长度不为零，里面的数据也有可能是null。
                q.add(list);
        }
        while (!q.isEmpty()) {
            ListNode cur = q.poll();
            pre.next = cur;
            if (cur.next!=null)
                q.add(cur.next);
            pre = cur;
        }
        return head.next;
    }
    
    static public void main (String argv[]) {
    	ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(5);
        a1.next=a2;
        ListNode b1=new ListNode(2);
        ListNode b2=new ListNode(4);
        b1.next=b2;
        ArrayList<ListNode> testArrayList=new ArrayList();
        testArrayList.add(a1);
        testArrayList.add(a2);
        
        ListNode result = (new MergekSortedLists()).mergeKLists(testArrayList);
    	
//    	ListNode result = new MergekSortedLists().mergeKLists(null);
//    	ListNode result2 = new MergekSortedLists().mergeKLists(null);
//    	System.out.println(result);
    }
    
}
