package array.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTree(start, i - 1);
            List<TreeNode> right = generateTree(i + 1, end);
            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i); // Should new a root here for different cases
                    root.left = lnode;
                    root.right = rnode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
