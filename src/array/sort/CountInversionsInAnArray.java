package array.sort;

/**
 * Created by jli1 on 11/14/16.
 */
public class CountInversionsInAnArray {

    public int countInverstions(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int inversion = mergeSort(nums, temp, left, mid);
        inversion += mergeSort(nums, temp, mid + 1, right);

        inversion += merge(nums, temp, left, mid, right);
        return inversion;
    }

    private int merge(int[] nums, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int leftIdx = left;
        int rightIdx = mid + 1;
        int idx = left;
        int inversion = 0;
        while (leftIdx <= mid && rightIdx <= right) {
            if (temp[leftIdx] < temp[rightIdx]) {
                nums[idx++] = temp[leftIdx++];
            } else {
                nums[idx++] = temp[rightIdx++];
                inversion += (mid + 1) - leftIdx; // left is bigger than right, then add the num of inversion
            }
        }
        while (leftIdx <= mid) {
            nums[idx++] = temp[leftIdx++];
        }
        return inversion;
    }

    public static void main(String[] args) {
        int[] nums = {1, 20, 6, 4, 5};
        CountInversionsInAnArray c = new CountInversionsInAnArray();
        System.out.println(c.countInverstions(nums));
    }
}
