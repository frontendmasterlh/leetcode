package array.tree;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }


    // Full Complete Binary Tree indicates that all the position are filled.
    public int countNodes(TreeNode root) {
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    private int getRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.right;
            height++;
        }
        return height;
    }
}
