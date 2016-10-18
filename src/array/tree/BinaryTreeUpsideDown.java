package array.tree;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

 For example:Given a binary tree {1,2,3,4,5},

        1
       / \
      2   3
     / \
    4   5
 return the root of the binary tree [4,5,2,#,#,3,1].

        4
      / \
     5   2
        / \
       3   1
 */
public class BinaryTreeUpsideDown {
    public class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            TreeNode res = upsideDownBinaryTree(root);
            left.left = right;
            left.right = root;
            root.left = null;
            return root;
        }
        return root;
    }
}
