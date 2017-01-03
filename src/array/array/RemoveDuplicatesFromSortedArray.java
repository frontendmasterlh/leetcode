package array.array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    // Time: O(n) Space: O(1)
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int len = 0;     //It means the first index (e.g. 0).
        for (int i = 1; i < nums.length; i++) {
            if (nums[len] != nums[i]) {
                nums[++len] = nums[i]; // If different, replace the next one.
            }
        }
        return len + 1;
    }
}
