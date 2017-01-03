package array.sort;

import java.util.Random;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
        // // Method 1: Priority Queue
        // PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        //     public int compare(Integer o1, Integer o2) {
        //         if (o1 > o2) {
        //             return -1;
        //         } else if (o1 < o2) {
        //             return 1;
        //         } else {
        //             return 0;
        //         }
        //     }
        // });

        // for (int num : nums) {
        //     pq.offer(num);
        // }
        // int res = pq.poll();
        // for (int i = 1; i < k; i++) {
        //     res = pq.poll();
        // }
        // return res;

        // Method 2: Quick Sort
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int helper(int[] nums, int left, int right, int rank) {
        if (left == right) {
            return nums[left];
        }
        int pos = partition(nums, left, right);
        if (pos + 1 == rank) {
            return nums[pos];
        } else if (pos + 1 < rank) {
            return helper(nums, pos + 1, right, rank);
        } else {
            return helper(nums, left, pos - 1, rank);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIdx = getRandom(left, right);
        int pivot = nums[pivotIdx];
        swap(nums, right, pivotIdx);
        int l = left;
        int r = right - 1;
        while (l <= r) {
            if (nums[l] < pivot) {
                l++;
            } else if (nums[r] >= pivot) {
                r--;
            } else {
                swap(nums, l++, r--);
            }
        }
        swap(nums, l, right);
        return l;
    }

    private int getRandom(int left, int right) {
        return left + new Random().nextInt(right - left + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
