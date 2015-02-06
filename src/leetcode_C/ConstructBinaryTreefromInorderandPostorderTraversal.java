package leetcode_C;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x){
		val = x;
		left = null;
		right = null;
	}
}

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	private TreeNode build (int[]  postorder, int[] inorder, int pl, int pr, int il, int ir) {
        TreeNode root = null;
        if (pl > pr || il > ir)
            return root;
        root = new TreeNode (postorder[pr]);
        int i;
        for (i = ir; i>= il && postorder[pr]!= inorder[i]; i--);//From ir
        
        root.left = build(postorder, inorder, pl, pr - 1 - (ir- i), il, i-1);
        root.right= build(postorder, inorder, pr - (ir - i), pr-1, i+1, ir);
        
        return root;   
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int m = postorder.length;
        int n = inorder.length;
        if (m==0 || n == 0)
            return null;
        return build(postorder, inorder, 0, m-1, 0, n-1);
    }
}
