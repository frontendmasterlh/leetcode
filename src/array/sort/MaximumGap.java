package array.sort;

/**
 * Created by jli1 on 10/24/16.
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        if (max == min) {
            return 0;
        }
        int len = (max - min) / (n - 1);
        if (len == 0) {
            len++;
        }
        int k = ((max - min) / len) + 1; //we must set this k since len is the floor so len <= (max - min) / (n - 1) < len + 1
        int[] localMax = new int[k];
        int[] localMin = new int[k];
        for (int i = 0; i < k; i++) {
            localMax[i] = Integer.MIN_VALUE;
            localMin[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int offset = (nums[i] - min) / len;
            localMax[offset] = Math.max(localMax[offset], nums[i]);
            localMin[offset] = Math.min(localMin[offset], nums[i]);
        }

        int left = 0;
        int right = 1;
        int res = len;
        while(left < k - 1) {
            while (right < k && localMax[right] == Integer.MIN_VALUE && localMin[right] == Integer.MAX_VALUE) {
                right++;
            }
            if (right >= k) {
                break;
            }
            res = Math.max(res, localMin[right] - localMax[left]);
            left = right;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumGap m = new MaximumGap();
        int[] nums = {3, 6, 9, 1};
        System.out.println(m.maximumGap(nums));
    }
}
