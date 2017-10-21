package array.graph;

import java.util.*;

public class ValidBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isValid(List<TreeNode> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return true;
        }
        Set<TreeNode> set = new HashSet<>();
        // Each node has only 1 parent.
        for (TreeNode node : nodes) {
            if (node.left != null) {
                if (set.contains(node.left)) {
                    return false;
                } else {
                    set.add(node.left);
                }
            }
            if (node.right != null) {
                if (set.contains(node.right)) {
                    return false;
                } else {
                    set.add(node.right);
                }
            }
        }
        int count = 0;
        TreeNode start = null;
        for (TreeNode node : nodes) {
            if (!set.contains(node)) {
                start = node;
                count++;
            }
        }
        // There's only 1 start node.
        if (count > 1) {
            return false;
        }

        // All the children will be traversed.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                set.remove(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                set.remove(cur.right);
            }
        }
        return set.size() == 0;
    }
}
