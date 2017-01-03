package array.tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BinarySearchTreeIterator {
    public class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        TreeNode p = cur.right;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        return cur.val;
    }
}
