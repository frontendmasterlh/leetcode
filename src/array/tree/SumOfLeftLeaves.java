package array.tree;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    // When consider leafNode, use a helper to difficiate the root
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || isLeafNode(root)) {
            return 0;
        }
        return dfsHelper(root);
    }

    private int dfsHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeafNode(root)) {
            return root.val;
        }
        int left = dfsHelper(root.left);
        int right = dfsHelper(root.right);
        int sum = left;
        if (!isLeafNode(root.right)) {
            sum += right;
        }
        return sum;
    }

    private boolean isLeafNode(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        ;
    }
}
