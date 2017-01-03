package array.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] count = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, count, index, 0, nums.length - 1);

        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] count, int[] index, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, count, index, start, mid);
        mergeSort(nums, count, index, mid + 1, end);
        merge(nums, count, index, start, end);
    }

    private void merge(int[] nums, int[] count, int[] index, int start, int end) {
        int mid = start + (end - start) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int rightCount = 0;
        int[] newIndex = new int[end - start + 1];
        int sortedIndex = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[index[leftIndex]] > nums[index[rightIndex]]) {
                newIndex[sortedIndex] = index[rightIndex];
                rightIndex++;
                rightCount++;
            } else {
                newIndex[sortedIndex] = index[leftIndex];
                count[index[leftIndex]] += rightCount;
                leftIndex++;
            }
            sortedIndex++;
        }
        while (leftIndex <= mid) {
            newIndex[sortedIndex] = index[leftIndex];
            count[index[leftIndex]] += rightCount;
            leftIndex++;
            sortedIndex++;
        }
        while (rightIndex <= end) {
            newIndex[sortedIndex] = index[rightIndex];
            rightIndex++;
            rightCount++;
            sortedIndex++;
        }
        for (int i = start; i <= end; i++) {
            index[i] = newIndex[i - start];
        }
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
        int[] nums = {5,2,6,1};
        List<Integer> res = c.countSmaller(nums);
        for (Integer num : res) {
            System.out.print(num + " ");
        }
    }
}
