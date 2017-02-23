package array.array;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        // Method 1: Brute force Time: O(n^2)

        // Method 2: Use HashSet Time: O(n) Space: O(n)

        // Method 3: Sort Time: O(nlogn)

        // Method 3.2: Binary Search. Time: O(nlogn)

        // Method 4: Find circle in linked list!
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(f.findDuplicate(nums));
    }
}
