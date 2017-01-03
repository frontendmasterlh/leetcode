package array.tree;

import java.util.Stack;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 */
public class InorderSuccessorInBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean isNext = false;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode t = stack.pop();
                if (isNext) {
                    return t;
                }
                if (t.val == p.val) {
                    isNext = true;
                }
                cur = t.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        InorderSuccessorInBST i = new InorderSuccessorInBST();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        TreeNode res = i.inorderSuccessor(root, root.left.right);
        System.out.println(res.val + " " + root.val);
    }
}
