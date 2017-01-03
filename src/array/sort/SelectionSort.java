package array.sort;

/**
 * Created by jli1 on 11/5/16.
 */
public class SelectionSort {

    // Time: O(n^2) Space: O(1)
    public void selectionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int global = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[global] > nums[j]) {
                    global = j;
                }
            }
            swap(nums, global, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int[] nums = {3, 5, 1, 2, 8, 4};
        s.selectionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
