package array.tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int[] count = new int[]{0};
        int[] res = new int[1];
        helper(root, k, count, res);
        return res[0];
    }

    private void helper(TreeNode root, int k, int[] count, int[] res) {
        if (root == null) {
            return;
        }
        helper(root.left, k, count, res);
        count[0]++;
        if (count[0] == k) {
            res[0] = root.val;
        }
        helper(root.right, k, count, res);
    }


    public int kthSmallestWithStack(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        findSmallest(root, stack);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            count++;
            if (count == k) {
                return t.val;
            }
            TreeNode r = t.right;
            while (r != null) {
                stack.push(r);
                r = r.left;
            }
        }
        return -1;
    }

    private void findSmallest(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        ;
    }
}
