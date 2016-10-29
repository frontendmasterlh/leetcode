package array.binarysearch;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] < nums[mid])) {
            return mid;
        }
        if (mid < nums.length - 1 && nums[mid + 1] > nums[mid]) {
            return findPeak(nums, mid + 1, right);
        } else {
            return findPeak(nums, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        int[] nums = {1, 2};
        System.out.println(f.findPeakElement(nums));
    }
}
