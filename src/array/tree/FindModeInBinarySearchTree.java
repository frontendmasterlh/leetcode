package array.tree;

import java.util.Map;

/**
 * Created by jli1 on 1/31/17.
 */
public class FindModeInBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        // Method 1: hashMap O(n) space
        // List<Integer> candidates = new ArrayList<>();
        // Map<Integer, Integer> map = new HashMap<>();
        // int[] max = new int[]{Integer.MIN_VALUE};

        // inorder(root, map, max);

        // for (Integer key : map.keySet()) {
        //     if (map.get(key) == max[0]) {
        //         candidates.add(key);
        //     }
        // }

        // int[] res = new int[candidates.size()];
        // for (int i = 0; i < res.length; i++) {
        //     res[i] = candidates.get(i);
        // }
        // return res;

        // Method 2: O(1) space
        int[] max = new int[]{0};
        int[] maxCount = new int[]{0};
        int[] cur = new int[]{0};
        int[] curCount = new int[]{0};
        inorder(root, max, maxCount, cur, curCount, null);
        int[] res = new int[max[0]];
        // Reset the count.
        max[0] = 0; // Use this to put candidates to their positions
        curCount[0] = 0;
        inorder(root, max, maxCount, cur, curCount, res);
        return res;
    }

    private void inorder(TreeNode root, int[] max, int[] maxCount, int[] cur, int[] curCount, int[] res) {
        if (root == null) {
            return;
        }
        inorder(root.left, max, maxCount, cur, curCount, res);
        if (cur[0] != root.val) {
            cur[0] = root.val;
            curCount[0] = 0;
        }
        curCount[0]++;
        if (curCount[0] > maxCount[0]) {
            maxCount[0] = curCount[0];
            max[0] = 1; // Reset length to 1.
        } else if (curCount[0] == maxCount[0]) {
            if (res != null) {
                res[max[0]] = root.val;
            }
            max[0]++;
        }
        inorder(root.right, max, maxCount, cur, curCount, res);
    }

    private void inorder(TreeNode root, Map<Integer, Integer> map, int[] max) {
        if (root == null) {
            return;
        }
        inorder(root.left, map, max);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max[0] = Math.max(max[0], map.get(root.val));
        inorder(root.right, map, max);
    }
}
