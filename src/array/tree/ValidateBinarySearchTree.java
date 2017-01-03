package array.tree;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val = x;
            left = null;
            right = null;
        };
    }

    public class ResultType {
        boolean isBST;
        int maxVal;
        int minVal;
        public ResultType(boolean x, int y, int z) {
            isBST = x;
            maxVal = y;
            minVal = z;
        }
    }

    public boolean isValidBST(TreeNode root) {
        // // Method 1: traverse
        // int[] lastVal = {Integer.MIN_VALUE};
        // boolean[] firstNode = {true};
        // return isValidBST(root, lastVal, firstNode);

        // Method 2: Divide and Conquer
        ResultType res = validateHelper(root);
        return res.isBST;
    }

    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);
        if (!left.isBST || !right.isBST) {
            return new ResultType(false, 0, 0);
        }
        if (root.left != null && left.maxVal >= root.val ||
            root.right != null && right.minVal <= root.val) { // Check for root's children is necessary
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true, Math.max(root.val, right.maxVal), Math.min(root.val, left.minVal));
    }


    private boolean isValidBST(TreeNode root, int[] lastVal, boolean[] firstNode) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left, lastVal, firstNode)) {
            return false;
        }
        if (!firstNode[0] && lastVal[0] >= root.val) {
            return false;
        }
        lastVal[0] = root.val;
        firstNode[0] = false;
        if (!isValidBST(root.right, lastVal, firstNode)) {
            return false;
        } else {
            return true;
        }
    }
}
