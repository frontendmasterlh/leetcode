package array.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String res = sb.toString();
        if (res.charAt(0) == '0') {
            return "0";
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 3, 8, 2, 6, 4, 7, 1};
        Arrays.sort(nums1);

        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(2);
        nums.add(8);
        nums.add(6);
        Collections.sort(nums, Collections.reverseOrder()
//                new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -1;
//            }
//        }
        );

        for (Integer num : nums) {
            System.out.println(num);
        }
    }
}
