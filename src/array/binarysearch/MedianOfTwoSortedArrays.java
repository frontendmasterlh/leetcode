package array.binarysearch;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }

    private double findKth(int[] A, int AStart, int[] B, int BStart, int k) {
        if (AStart >= A.length) {
            return B[BStart + k - 1];
        }
        if (BStart >= B.length) {
            return A[AStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[AStart], B[BStart]);
        }
        int AKey = AStart + k/2 - 1 < A.length ? A[AStart + k/2 - 1] : Integer.MAX_VALUE; //Note: AKey is value, not index
        int BKey = BStart + k/2 - 1 < B.length ? B[BStart + k/2 - 1] : Integer.MAX_VALUE;
        if (AKey < BKey) {
            return findKth(A, AStart + k/2, B, BStart, k - k/2);
        } else {
            return findKth(A, AStart, B, BStart + k/2, k - k/2);
        }
    }
}
