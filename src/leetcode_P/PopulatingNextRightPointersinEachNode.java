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
        TreeLinkNode topleft = root;
        while (topleft!=null) {
            TreeLinkNode now = topleft;
            while (now != null) {
                if (now.left!=null){
                    now.left.next = now.right;
                }
                if (now.right!=null && now.next !=null){
                    now.right.next = now.next.left;
                }
                now = now.next;
            }
            topleft = topleft.left;
        }
    }
    
    static public void main (String[] argv) {
    	;
    }
}
