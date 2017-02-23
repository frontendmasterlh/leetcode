package array.array;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        if (nums == null) {
            return Integer.MIN_VALUE;
        }
        Integer max = null;
        Integer sec = null;
        Integer third = null;
        for (Integer num : nums) {
            if (num.equals(max) || num.equals(sec) || num.equals(third)) {
                continue;
            }
            if (max == null || max < num) {
                third = sec;
                sec = max;
                max = num;
            } else if (sec == null || sec < num) {
                third = sec;
                sec = num;
            } else if (third == null || third < num) {
                third = num;
            }
        }
        if (third == null) {
            return max;
        } else {
            return third;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        ThirdMaximumNumber t = new ThirdMaximumNumber();
        System.out.println(t.thirdMax(nums));
    }
}
