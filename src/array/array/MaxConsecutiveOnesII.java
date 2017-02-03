package array.array;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

 Example 1:

 Input: [1,0,1,1,0]
 Output: 4
 Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 After flipping, the maximum number of consecutive 1s is 4.
 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0, zero = 0;
        int k = 1;
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[l++] == 0) {
                    zero--;
                }
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesII m = new MaxConsecutiveOnesII();
        int[] nums = {0,0,0,0};
        System.out.println(m.findMaxConsecutiveOnes(nums));
    }
}
