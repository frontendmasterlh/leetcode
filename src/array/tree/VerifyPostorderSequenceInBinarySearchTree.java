package array.tree;

/**
 * Created by jli1 on 10/16/16.
 */
public class VerifyPostorderSequenceInBinarySearchTree {

    // Similar with verifyPreorder, postorder first checks from the last element to the left.
    // Time: O(n) Space: O(1)
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        int i = postorder.length;
        int max = Integer.MAX_VALUE;
        for (int j = postorder.length - 1; j >= 0; j--) {
            if (postorder[j] > max) {
                return false;
            }
            while (i <postorder.length && postorder[i] > postorder[j]) {
                max = postorder[i++];
            }
            postorder[--i] = postorder[j];
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyPostorderSequenceInBinarySearchTree v = new VerifyPostorderSequenceInBinarySearchTree();
        int postorder[] = {2, 1, 5, 6, 8, 7, 3};
        System.out.println(v.verifyPostorder(postorder));
    }
}
