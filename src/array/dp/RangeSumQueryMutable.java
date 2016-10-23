package array.dp;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class RangeSumQueryMutable {
//    int[] btree;
//    int[] arr;
//
//    // Binary Index Tree
//    public RangeSumQueryMutable(int[] nums) {
//        arr = nums;
//        btree = new int[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            add(i + 1, nums[i]);
//        }
//    }
//
//    void update(int i, int val) {
//        add(i + 1, val - arr[i]);
//        arr[i] = val;
//    }
//
//    public int sumRange(int i, int j) {
//        return sumHelper(j + 1) - sumHelper(i); // Keep in mind that binary index tree is 1-based.
//    }
//
//    private void add(int i, int value) {
//        for (int j = i; j < btree.length; j += (j&(-j))) { // Find low bit every time
//            btree[j] += value;
//        }
//    }
//
//    private int sumHelper(int i) {
//        int sum = 0;
//        for (int j = i; j >= 1; j -= (j & (-j))) {
//            sum += btree[j];
//        }
//        return sum;
//    }

    public class TreeNode {
        int start;
        int end;
        int sum;
        TreeNode left, right;
        public TreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }

    TreeNode root = null;
    // Segment Tree
    public RangeSumQueryMutable(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        this.root = buildTree(nums, 0, nums.length - 1);
    }

    void update(int i, int val) {
        updateHelper(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(left, right, nums[left]);
        }
        TreeNode cur = new TreeNode(left, right);
        int mid = left + (right - left) / 2;
        cur.left = buildTree(nums, left, mid);
        cur.right = buildTree(nums, mid + 1, right);
        cur.sum = cur.left.sum + cur.right.sum;
        return cur;
    }

    private void updateHelper(TreeNode root, int i, int val) {
        if (root == null) {
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (i <= mid) {
            updateHelper(root.left, i, val);
        } else {
            updateHelper(root.right, i, val);
        }
        if (root.start == root.end && i == root.start) {
            root.sum = val;
            return;
        }
        root.sum = root.left.sum + root.right.sum;
    }

    private int sumRangeHelper(TreeNode root, int i, int j) {
        if (root == null || i < root.start || j > root.end || i > j) {
            return 0;
        }
        if (i <= root.start && j >= root.end) { // if [i, j] covers [root.start, root.end]
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        return sumRangeHelper(root.left, i, Math.min(mid, j))
               + sumRangeHelper(root.right, Math.max(mid + 1, i), j);
    }

    public static void main(String[] args) {
        int[] nums = {0, 9, 5, 7, 3};
        RangeSumQueryMutable r = new RangeSumQueryMutable(nums);

        System.out.println(r.sumRange(4,4));
        System.out.println(r.sumRange(2,4));
        System.out.println(r.sumRange(3,3));

//        System.out.println(r.sumRange(0, 2));
//        r.update(0, 3);
//        System.out.println(r.sumRange(1, 1));
//        System.out.println(r.sumRange(0, 1));
//        r.update(1, -3);
//        System.out.println(r.sumRange(0, 1));
    }
}
