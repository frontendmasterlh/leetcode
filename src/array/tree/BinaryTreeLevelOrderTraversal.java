package array.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jli1 on 11/14/16.
 */
public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // // Method 1: BFS
        // List<List<Integer>> res = new ArrayList<>();
        // if (root == null) {
        //     return res;
        // }
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);
        // while (!queue.isEmpty()) {
        //     List<Integer> level = new ArrayList<>();
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         TreeNode cur = queue.poll();
        //         level.add(cur.val);
        //         if (cur.left != null) {
        //             queue.offer(cur.left);
        //         }
        //         if (cur.right != null) {
        //             queue.offer(cur.right);
        //         }
        //     }
        //     res.add(level);
        // }
        // return res;

        // Method 2: DFS
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int maxLevel = 0;
        while (true) {
            List<Integer> level = new ArrayList<>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }
            res.add(level);
            maxLevel++;
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> level, int curLevel, int maxLevel) {
        if (root == null || curLevel > maxLevel) {
            return;
        }
        if (curLevel == maxLevel) {
            level.add(root.val);
            return;
        }
        dfs(root.left, level, curLevel + 1, maxLevel);
        dfs(root.right, level, curLevel + 1, maxLevel);
    }
}
