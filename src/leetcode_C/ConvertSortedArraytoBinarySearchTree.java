package leetcode_C;

/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.*/

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
        if (num==null || num.length == 0)
            return null;
        int i = 0, j = num.length - 1;
        return generateTree (num, i, j);
    }
    
    private TreeNode generateTree (int[] num, int left, int right) {
        if  (left > right)
            return null;
        if (left == right)
            return new TreeNode (num[left]);
        int mid = (left + right) /2;
        TreeNode root = new TreeNode (num[mid]);
        root.left = generateTree (num, left, mid - 1);
        root.right= generateTree (num, mid + 1, right);
        return root;
    }
    
    static public void main (String[] argv) {
    	;
    }
}
