package leetcode_P;

import java.util.*;

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
//		//The 1st method: Using Queue with the size. 
//        if (root==null)
//            return ;
//        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode> ();
//        q.add(root);
//        while (!q.isEmpty()){
//            int size = q.size();
//            for (int i=0; i < size; i++) {
//                TreeLinkNode cur = q.poll();
//                if (cur.left != null){
//                    q.offer(cur.left);
//                }
//                if (cur.right != null)
//                    q.offer(cur.right);
//                if (i < size - 1){
//                    cur.next = q.peek();
//                }
//            }
//        }
		
        // //The 2nd method: Using Queue. Time: O(n)
        // if (root == null)
        //     return ;
        // Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode> ();
        // q.offer(root);
        // q.offer(null);
        // while (!q.isEmpty()){
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
		
		//The 3rd method: Using recursion. Time: O(n)
		if (root==null)
            return ;
         TreeLinkNode leftnext = null;
         TreeLinkNode rightnext = null;
         TreeLinkNode findnext = null;
         if (root.left!=null){
        	 leftnext = root.right;
        	 findnext = root.next;
        	 while (leftnext==null && findnext!=null){
        		 if (findnext.left!=null){
        			 leftnext = findnext.left;
        			 break;
        		 }
        		 if (findnext.right!=null){
        			 leftnext = findnext.right;
        			 break;
        		 }
        		 findnext = findnext.next;
        	 }
        	 root.left.next = leftnext;
         }
         if (root.right!= null){
        	 rightnext = null;
        	 findnext = root.next;
        	 while (rightnext==null && findnext!=null){
        		 if (findnext.left!=null){
        			 rightnext = findnext.left;
        			 break;
        		 }
        		 if (findnext.right!=null){
        			 rightnext = findnext.right;
        			 break;
        		 }
        		 findnext = findnext.next;
        	 }
        	 root.right.next = rightnext;
         }
         connect(root.right);
         connect(root.left);
    }
	
	static public void main (String[] argv){
		;
	}
}