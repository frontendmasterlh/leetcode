package array.sort;

import java.util.Random;
import java.util.Stack;

/**
 * https://stackoverflow.com/questions/20398799/find-k-nearest-points-to-point-p-in-2-dimensional-plane
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
//        quickSort(nums, 0, nums.length - 1);
        quickSortWithIteration(nums, 0, nums.length - 1);
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

    private void quickSortWithIteration(int[] nums, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            int r = stack.pop();
            int l = stack.pop();

            int pivotPos = partition(nums, l, r);
            if (pivotPos - 1 > l) {
                stack.push(l);
                stack.push(pivotPos - 1);
            }
            if (pivotPos + 1 < r) {
                stack.push(pivotPos + 1);
                stack.push(r);
            }
        }
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
