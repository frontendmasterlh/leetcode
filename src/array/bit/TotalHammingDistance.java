package array.bit;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Now your job is to find the total Hamming distance between all pairs of the given numbers.

 Example:
 Input: 4, 14, 2

 Output: 6

 Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 showing the four bits relevant in this case). So the answer will be:
 HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 Note:
 Elements of the given array are in the range of 0 to 10^9
 Length of the array will not exceed 10^4.
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        // Method 1: two for loops (Time Limit Exceeded)
        // int count = 0;
        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int xor = nums[i] ^ nums[j];
        //         count += Integer.bitCount(xor);
        //     }
        // }
        // return count;

        // Method 2: Use HashMap to memorize result (Time Limit Exceeded)
        // int count = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int xor = nums[i] ^ nums[j];
        //         Integer temp = map.get(xor);
        //         if (temp == null) {
        //             temp = Integer.bitCount(xor);
        //             map.put(xor, temp);
        //         }
        //         count += temp;
        //     }
        // }
        // return count;

        // Method 3: Count the orrcurance of 1, then the result is the sum of # of 1 multiple by # of 0
        int count = 0;
        int[] temp = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    temp[i]++;
                }
            }
        }
        for (int i = 0; i < 32; i++) {
            count += (nums.length - temp[i]) * temp[i];
        }
        return count;
    }
}
