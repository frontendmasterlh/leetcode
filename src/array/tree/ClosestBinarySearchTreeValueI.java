package array.tree;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note: Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValueI {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    // Recursion Time: O(logN) Space: O(N)
    public int closestValue(TreeNode root, double target) {
        TreeNode kid = root.val < target ? root.right : root.left;

        if (kid == null) {
            return root.val;
        }
        int closest = closestValue(kid, target);
        return Math.abs(root.val - target) > Math.abs(closest - target) ? closest : root.val;
    }

    // Iteration Time: O(logN) Space: O(1)
    public int closestValueWithIteration(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            closest = Math.abs(closest - target) < Math.abs(root.val - target) ? closest : root.val;
            root = root.val < target ? root.right : root.left;
        }
        return closest;
    }

    public static void main(String[] args) {
        ClosestBinarySearchTreeValueI c = new ClosestBinarySearchTreeValueI();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(15);
        System.out.println(c.closestValue(root, 3.5));
        System.out.println(c.closestValueWithIteration(root, 3.5));
    }
}
