package array.tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class VerifyPreorderSerializationOfABinaryTree {

    // Use stack to mimic the preOrder traverse. Once met num,#,# then replace them with a #
    // Check stack size is 1 and the only element left is #
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] arr = preorder.split(",");
        for (String str : arr) {
            stack.push(str);

            while(stack.size() >= 3 &&
                  stack.get(stack.size() - 1).equals("#") &&
                  stack.get(stack.size() - 2).equals("#") &&
                  !stack.get(stack.size() - 3).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
