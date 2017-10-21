package array.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                sb.append(cur.val).append(",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                sb.append("null").append(",");
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        int idx = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty() && idx < arr.length) {
            TreeNode cur = q.poll();
            if (idx < arr.length) {
                if (!"null".equals(arr[idx])) {
                    cur.left = new TreeNode(Integer.parseInt(arr[idx]));
                    q.offer(cur.left);
                }
                idx++;
            }
            if (idx < arr.length) {
                if (!"null".equals(arr[idx])) {
                    cur.right = new TreeNode(Integer.parseInt(arr[idx]));
                    q.offer(cur.right);
                }
                idx++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        String str = s.serialize(root);
        System.out.println(str);
        TreeNode root2 = s.deserialize(str);
        assert root2 != null;
        assert root2.val == 1;
        assert root2.left == null;
        assert (root2.right.val == root.right.val);
        System.out.println("Happy!");
    }
}
