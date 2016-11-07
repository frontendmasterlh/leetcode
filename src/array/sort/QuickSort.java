package array.sort;

import java.util.Random;

/**
 * Created by jli1 on 11/5/16.
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(nums, left, right);
        quickSort(nums, left, pivotPos - 1);
        quickSort(nums, pivotPos + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIndex = findPivotIndex(left, right);
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
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

    private int findPivotIndex(int left, int right) {
        return left + new Random().nextInt(right - left + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] nums = {3, 5, 1, 2, 8, 4};
        q.quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
