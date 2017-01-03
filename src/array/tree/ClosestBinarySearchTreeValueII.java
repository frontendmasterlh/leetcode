package array.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

 Note:

 Given target value is a floating point.
 You may assume k is always valid, that is: k ≤ total nodes.
 You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 */
public class ClosestBinarySearchTreeValueII {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Integer> pre = new Stack<>();
        Stack<Integer> next = new Stack<>();

        getPredecessor(root, pre, target);
        getSucessor(root, next, target);

        for (int i = 0; i < k; i++) {
            if (pre.isEmpty()) {
                res.add(next.pop());
            } else if (next.isEmpty()) {
                res.add(pre.pop());
            } else if (Math.abs(next.peek() - target) < Math.abs(pre.peek() - target)) {
                res.add(next.pop());
            } else {
                res.add(pre.pop());
            }
        }
        return res;
    }

    private void getPredecessor(TreeNode root, Stack<Integer> stack, double target) {
        if (root == null) {
            return;
        }
        getPredecessor(root.left, stack, target);
        if (root.val > target) {
            return;
        }
        stack.push(root.val);
        getPredecessor(root.right, stack, target);
    }

    private void getSucessor(TreeNode root, Stack<Integer> stack, double target) {
        if (root == null) {
            return;
        }
        getSucessor(root.right, stack, target);
        if (root.val <= target) {
            return;
        }
        stack.push(root.val);
        getSucessor(root.left, stack, target);
    }

    public static void main(String[] args) {
        ClosestBinarySearchTreeValueII c = new ClosestBinarySearchTreeValueII();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(15);
        List<Integer> res = c.closestKValues(root, 3.5, 3);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
