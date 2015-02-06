package leetcode_C;

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
		next = null;
	};
}

public class ConvertSortedListtoBinarySearchTree {
    ListNode list = null;
    
    private TreeNode generateTree (int begin, int end) {
        if (begin > end)
            return null;
        int mid = (begin + end) /2;
        TreeNode left = generateTree (begin, mid - 1);
        TreeNode root = new TreeNode (list.val);
        
        root.left = left;
        list = list.next;
        
        root.right = generateTree (mid+ 1, end);
        return root;
    }
    
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        list = head;
        return generateTree (0, len -1);
    }
    
    static public void main (String[] argv) {
    	;
    }
}
