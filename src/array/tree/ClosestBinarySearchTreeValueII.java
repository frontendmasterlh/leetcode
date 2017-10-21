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

    public List<Integer> closestKValuesII(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        initPredecessor(root, pred, target);
        initSucessor(root, succ, target);
        if (!pred.isEmpty() && !succ.isEmpty() && pred.peek().val == succ.peek().val) {
            getPredecessorII(pred);
        }
        for (int i = 0; i < k ; i++) {
            if (pred.isEmpty()) {
                res.add(getSucessorII(succ));
            } else if (succ.isEmpty()) {
                res.add(getPredecessorII(pred));
            } else {
                double prediff = Math.abs(pred.peek().val - target);
                double sucdiff = Math.abs(succ.peek().val - target);
                if (prediff < sucdiff) {
                    res.add(getPredecessorII(pred));
                } else {
                    res.add(getSucessorII(succ));
                }
            }
        }
        return res;
    }

    private void initPredecessor(TreeNode root, Stack<TreeNode> pred, double target) {
        while (root != null) {
            double diff = Math.abs(root.val - target);
            if (diff < 0.001) {
                pred.push(root);
                break;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private void initSucessor(TreeNode root, Stack<TreeNode> succ, double target) {
        while (root != null) {
            double diff = Math.abs(root.val - target);
            if (diff < 0.001) {
                succ.push(root);
                break;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private int getPredecessorII(Stack<TreeNode> pred) {
        int res = pred.peek().val;
        TreeNode cur = pred.pop();
        cur = cur.left;
        while (cur != null) {
            pred.push(cur);
            cur = cur.right;
        }
        return res;
    }

    private int getSucessorII(Stack<TreeNode> succ) {
        int res = succ.peek().val;
        TreeNode cur = succ.pop();
        cur = cur.right;
        while (cur != null) {
            succ.push(cur);
            cur = cur.left;
        }
        return res;
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
        List<Integer> res2 = c.closestKValuesII(root, 3.5, 3);
        for (int num : res2) {
            System.out.println(num);
        }
    }
}
