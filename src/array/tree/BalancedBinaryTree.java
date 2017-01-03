package array.tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int res = helper(root);
        return res != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
