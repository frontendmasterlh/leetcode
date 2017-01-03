package leetcode_C;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	private TreeNode build (int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        TreeNode root = null;
        if (pl > pr || il > ir)
            return root;
        root = new TreeNode (preorder[pl]);
        int i;
        for (i = il; i<= ir && preorder[pl]!= inorder[i]; i++);
        
        root.left = build(preorder, inorder, pl+1, pl+(i - il),  il, i-1);
        root.right = build(preorder,inorder, pl+(i - il) +1, pr, i+1, ir);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int m = preorder.length;
        int n = inorder.length;
        if (m==0 || n==0)
            return null;
        return build(preorder, inorder, 0, m-1, 0, n-1);
    }
    
    static public void main (String[] argv){
    	;
    }
}
