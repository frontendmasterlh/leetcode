package array.tree;

/**
 * Created by jli1 on 11/27/16.
 */
public class SerializeAndDeserializeBST {
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
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        return buildTree(arr, 0, arr.length - 1);
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val + ",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    private TreeNode buildTree(String[] arr, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[l]));
        int splitIndex = findIndex(arr, root.val, l + 1, r);
        root.left = buildTree(arr, l + 1, splitIndex - 1);
        root.right = buildTree(arr, splitIndex, r);
        return root;
    }

    private int findIndex(String[] arr, int target, int l, int r) {
        int i = l;
        for (; i <= r; i++) {
            if (Integer.parseInt(arr[i]) > target) {
                break;
            }
        }
        return i;
    }
}
