package array.tree;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
 * where largest means subtree with largest number of nodes in it.

 Note:
 A subtree must include all of its descendants.
 Here's an example:

      10
     / \
    5  15
   / \   \
  1   8   7
 The Largest BST Subtree in this case is the highlighted one.
 The return value is the subtree's size, which is 3.



 Hint:

 You can recursively use algorithm similar to 98.
 Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
 Follow up:
 Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTSubtree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private int[] helper(TreeNode root, int[] res) {
        if (root == null) {
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = helper(root.left, res);
        int[] right = helper(root.right, res);
        if (left[2] < root.val && right[1] > root.val) {
            int min = Math.min(root.val, left[1]);
            int max = Math.max(root.val, right[2]);
            res[0] = Math.max(res[0], left[0] + right[0] + 1); // Update the global value
            return new int[] {left[0] + right[0] + 1, min, max}; // Return the current value
        } else {
            return new int[] {0, Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        LargestBSTSubtree l = new LargestBSTSubtree();
        System.out.println(l.largestBSTSubtree(root));
    }
}
