package array.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples:
 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7


 return its vertical order traversal as:

 [
 [9],
 [3,15],
 [20],
 [7]
 ]


 Given binary tree [3,9,20,4,5,2,7],

 _3_
 /   \
 9    20
 / \   / \
 4   5 2   7


 return its vertical order traversal as:

 [
 [4],
 [9],
 [3,5,2],
 [20],
 [7]
 ]
 */
public class BinaryTreeVerticalOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode (int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] min = new int[1];
        dfsHelper(root, map, min, 0);

        for (int i = min[0]; map.containsKey(i) ; i++) {
            res.add(map.get(i));
        }
        return res;
    }

    private void dfsHelper(TreeNode root, Map<Integer, List<Integer>> map, int[] min, int col) {
        if (root == null) {
            return;
        }
        dfsHelper(root.left, map, min, col - 1);
        min[0] = Math.min(min[0], col);
        if (!map.containsKey(col)) {
            List<Integer> list = new ArrayList<>();
            map.put(col, list);
        }
        map.get(col).add(root.val);
        dfsHelper(root.right, map, min, col + 1);
    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal b = new BinaryTreeVerticalOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(2);
        List<List<Integer>> res = b.verticalOrder(root);

        for(List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
