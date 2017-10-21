package array.tree;

public class ConvertBinarySearchTreeToDoubleLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode[] head = new TreeNode[1];
        TreeNode[] pre = new TreeNode[1];
        dfsHelper(root, head, pre);
        return head[0];
    }

    private void dfsHelper(TreeNode root, TreeNode[] head, TreeNode[] pre) {
        if (root == null) {
            return;
        }
        dfsHelper(root.left, head, pre);
        if (pre[0] == null) {
            head[0] = root;
        } else {
            pre[0].right = root;
            root.left = pre[0];
        }
        pre[0] = root;

        dfsHelper(root.right, head, pre);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        ConvertBinarySearchTreeToDoubleLinkedList c = new ConvertBinarySearchTreeToDoubleLinkedList();
        TreeNode head = c.convert(root);
        while (head != null) {
            System.out.println(head.val);
            head = head.right;
        }
    }
}
