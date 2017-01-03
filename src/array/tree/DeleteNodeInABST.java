package array.tree;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInABST {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode larger = root.right;
                TreeNode pre = root;
                while (larger.left != null) {
                    pre = larger;
                    larger = larger.left;
                }
                larger.left = root.left;
                // if (pre != root) {
                pre.left = larger.right;
                larger.right = root.right;
                // }
                return larger;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
