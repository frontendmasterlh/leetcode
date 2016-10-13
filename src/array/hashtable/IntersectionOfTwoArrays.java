package array.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {
    // Method 1: HashSet Time: O(n) Space: O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] res = new int[set2.size()];
        int count = 0;
        for (Integer num :set2) {
            res[count++] = num;
        }
        return res;
    }

    public int[] intersectionWithSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        int count = 0;
        for (Integer num : list) {
            res[count++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = i.intersection(num1, num2);
        int[] res2 = i.intersectionWithSort(num1, num2);
        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : res2) {
            System.out.print(num + " ");
        }
    }
}
