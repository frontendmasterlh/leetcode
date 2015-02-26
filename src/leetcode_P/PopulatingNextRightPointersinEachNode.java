package leetcode_P;

class TreeLinkNode {
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	TreeLinkNode (int x) {
		val = x;
		left = null;
		right = null;
		next = null;
	};
}

public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
    	// //The 1st method: Using Queue. Time:O(n)
        // if (root == null)
        //     return ;        
        // Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode> ();
        // q.offer(root);
        // q.offer(null);
        // while (!q.isEmpty()) {
        //     TreeLinkNode cur = q.poll();
        //     if (cur != null) {
        //         cur.next = q.peek();
        //         if (cur.left != null)
        //             q.offer(cur.left);
        //         if (cur.right != null)
        //             q.offer(cur.right);
        //     }else {
        //         if (!q.isEmpty()){
        //             q.offer(null);
        //         }
        //     }
        // }
        
        // //The 2nd method: Using recursion. Time: O(n)
        // if (root == null)
        //     return ;
        // if (root.left != null) {
        //     root.left.next = root.right;
        // }
        // if (root.right != null && root.next != null) {
        //     root.right.next = root.next.left;
        // }
        // connect(root.left);
        // connect(root.right);
        
        //The 3rd method: Using iteration. Time: O(n)
        if (root == null)
            return ;
        TreeLinkNode topleft = root;
        while (topleft != null){
            TreeLinkNode now = topleft;
            while (now != null){
                if (now.left != null)
                    now.left.next = now.right;
                if (now.right != null && now.next != null)
                    now.right.next = now.next.left;
                now = now.next;     //In the same level.
            }
            topleft = topleft.left; //To the next level.
        }
    }
    
    static public void main (String[] argv) {
    	;
    }
}
