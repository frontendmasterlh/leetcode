package array.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        int count = 0;
        for (int num : list) {
            res[count++] = num;
        }
        return res;
    }

    public int[] intersectWithBinarySearch(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int start = 0;
        int intersection = 0;
        for (int num : nums1) {
            int bIndex = binarySearch1stOccur(nums2, start, nums2.length, num);
            if (bIndex >= 0) {
                start = bIndex + 1;
                nums1[intersection++] = num;
            }

        }
        return Arrays.copyOf(nums1, intersection);
    }

    private int binarySearch1stOccur(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] > target || (mid > left && nums[mid - 1] == target)) {
                right = mid;
            } else {
                return mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = i.intersectWithBinarySearch(num2, num1);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
