package array.sort;

/**
 * Created by jli1 on 11/5/16.
 */
public class MergeSort {
    public void mergeSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int[] helper = new int[nums.length];
        mergeSort(nums, helper, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, helper, left, mid);
        mergeSort(nums, helper, mid + 1, right);
        merge(nums, helper, left, mid, right);
    }

    private void merge(int[] nums, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = nums[i];
        }
        int leftIdx = left;
        int rightIdx = mid + 1;
        while (leftIdx <= mid && rightIdx <= right) {
            if (helper[leftIdx] < helper[rightIdx]) {
                nums[left++] = helper[leftIdx++];
            } else {
                nums[left++] = helper[rightIdx++];
            }
        }

        while (leftIdx <= mid) {
            nums[left++] = helper[leftIdx++];
        }
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] nums = {3, 5, 1, 2, 8, 4};
        m.mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
