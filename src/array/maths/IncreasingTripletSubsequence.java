package array.maths;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int max = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;
        for (int num : nums) {
            if (max >= num) {
                max = num;
            } else if (sec >= num) {
                sec = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(i.increasingTriplet(nums));
    }
}
