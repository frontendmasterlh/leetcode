package array.tree;

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

 You may assume each number in the sequence is unique.

 Follow up: Could you do it using only constant space complexity?
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            left = right = null;
        }
    }


    // Use a stack to keep track of the sequence
    // Then use a var called min to guarantee the candidate num is no less than min
    // Time: O(n) Space: O(n)
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < num) {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }

    // Use the original array
    public boolean verifyPreorder2(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        int i = -1;
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            while (i >= 0 && num > preorder[i]) {
                min = preorder[i--];
            }
            preorder[++i] = num;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(8);
        VerifyPreorderSequenceInBinarySearchTree v = new VerifyPreorderSequenceInBinarySearchTree();
        int[] preorder = {3, 1, 2, 7, 6, 5, 8};
        System.out.println(v.verifyPreorder(preorder));
        System.out.println(v.verifyPreorder2(preorder));
    }
}
