package array.tree;

/**
 * Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:
 Given binary tree,
        5
       / \
      1   5
     / \   \
    5   5   5
 return 4.
 */
public class CountUnivalueSubtrees {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] count = new int[]{0};
        helper(root, count, root.val);
        return count[0];
    }

    private boolean helper(TreeNode root, int[] count, int target) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            count[0]++;
            return true;
        }
        boolean left = helper(root.left, count, target);
        boolean right = helper(root.right, count, target);
        if (left && right && target == root.val) {
            count[0]++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CountUnivalueSubtrees c = new CountUnivalueSubtrees();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(c.countUnivalSubtrees(root));
    }
}
