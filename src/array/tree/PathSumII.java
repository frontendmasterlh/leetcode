package array.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, temp, res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum == root.val) {  // Remember this is the last step.
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        temp.add(root.val);
        helper(root.left, sum - root.val, temp, res);
        helper(root.right, sum - root.val, temp, res);
        temp.remove(temp.size() - 1);
    }
}
