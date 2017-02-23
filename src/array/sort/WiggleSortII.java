package array.sort;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        // // Time: O(NLogN) Space: O(N)
        // Arrays.sort(nums);
        // int n = nums.length;
        // int[] temp = new int[n];
        // int j = (n + 1) / 2;
        // int k = n;
        // for (int i = 0; i < n; i++) {
        //     if (i % 2 == 0) {
        //         temp[i] = nums[--j];
        //     } else {
        //         temp[i] = nums[--k];
        //     }
        // }
        // for (int i = 0; i < n; i++) {
        //     nums[i] = temp[i];
        // }

        // Method 2: Time: O(N) Space: O(N)
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        int mid = partition(temp, 0, nums.length - 1, nums.length / 2);
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = mid;
        }
        int l, r;
        if (nums.length % 2 == 0) {
            l = nums.length - 2;
            r = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l -= 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r += 2;
                }
            }
        } else {
            r = 0;
            l = nums.length - 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[r] = nums[i];
                    r += 2;
                } else if (nums[i] > mid) {
                    ans[l] = nums[i];
                    l -= 2;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }

    private int partition(int[] nums, int l, int r, int rank) {
        int left = l;
        int right = r;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        if (left - l == rank) {
            return pivot;
        } else if (left - l < rank) {
            return partition(nums, left + 1, r, rank - (left - l + 1));
        } else {
            return partition(nums, l, right - 1, rank);
        }
    }

    public static void main(String[] args) {
        WiggleSortII w = new WiggleSortII();
        int[] nums = {5,3,1,2,6,7,8,5,5};
        w.wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
