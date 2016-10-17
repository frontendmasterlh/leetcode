package array.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.

 Example:
 Given binary tree
 1
 / \
 2   3
 / \
 4   5
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Remove the leaves [4, 5, 3] from the tree

 1
 /
 2
 2. Remove the leaf [2] from the tree

 1
 3. Remove the leaf [1] from the tree

 []
 Returns [4, 5, 3], [2], [1].
 */
public class FindLeavesOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) {
            return res;
        }
        while (root != null) {
            root = helper(root, temp);
            res.add(new ArrayList<>(temp));
            temp.clear(); // Remember to clean the temp list
        }
        return res;
    }

    private TreeNode helper(TreeNode root, List<Integer> temp) {
        if (root == null) {
            return null;
        }
        if (isLeafNode(root)) {
            temp.add(root.val);
            return null;
        }
        TreeNode left = helper(root.left, temp);
        TreeNode right = helper(root.right, temp);
        if (left == null) {
            root.left = null;
        }
        if (right == null) {
            root.right = null;
        }
        return root;
    }

    private boolean isLeafNode(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        FindLeavesOfBinaryTree f = new FindLeavesOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        List<List<Integer>> res = f.findLeaves(root);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
