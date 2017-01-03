package array.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfsHelper(root, String.valueOf(root.val), res);
        return res;
    }

    private void dfsHelper(TreeNode root, String str, List<String> res) {
        if (root == null) {
            return;
        }
        if (isLeafNode(root)) {
            res.add(str);
            return;
        }
        if (root.left != null) {
            dfsHelper(root.left, str + "->" + String.valueOf(root.left.val), res);
        }
        if (root.right != null) {
            dfsHelper(root.right, str + "->" + String.valueOf(root.right.val), res);
        }
    }

    private boolean isLeafNode(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}
