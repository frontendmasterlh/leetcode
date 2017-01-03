package array.tree;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,

   1
    \
    3
   / \
  2   4
      \
       5
 Longest consecutive sequence path is 3-4-5, so return 3.

    2
     \
     3
    /
   2
  /
 1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0, root.val - 1);
    }

    private int helper(TreeNode root, int length, int preValue) {
        if (root == null) {
            return length;
        }
        int newLen = preValue + 1 == root.val ? length + 1 : 1;
        return Math.max(newLen, Math.max(helper(root.left, newLen, root.val), helper(root.right, newLen, root.val)));
    }

    public static void main(String[] args) {
        BinaryTreeLongestConsecutiveSequence b = new BinaryTreeLongestConsecutiveSequence();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.left = new TreeNode(2);

        System.out.println(b.longestConsecutive(root));
    }
}
