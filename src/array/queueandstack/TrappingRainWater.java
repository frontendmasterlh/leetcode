package array.queueandstack;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        // // Method 1: two pointers
        // if (height == null || height.length == 0) {
        //     return 0;
        // }
        // int high = 0;
        // for (int i = 1; i < height.length; i++) {
        //     if (height[high] < height[i]) {
        //         high = i;
        //     }
        // }

        // int water = 0;
        // int h = 0;
        // for (int i = 0; i < high; i++) {
        //     if (h > height[i]) {
        //         water += h - height[i];
        //     } else {
        //         h = height[i];
        //     }
        // }
        // h = 0;
        // for (int i = height.length - 1; i > high; i--) {
        //     if (h > height[i]) {
        //         water += h - height[i];
        //     } else {
        //         h = height[i];
        //     }
        // }
        // return water;
        //[0,2,0]
        // i i j
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int max = 0;
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                max += (leftMax - height[i]);
                i++;
            } else {
                max += (rightMax - height[j]);
                j--;
            }
        }
        return max;
        /* Method 2: stack
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int j = stack.pop();
                if (stack.isEmpty() || height[i] == height[j]) {
                    continue;
                }
                int h = Math.min(height[stack.peek()], height[i]) - height[j];
                int w = (i - 1) - stack.peek();
                water += h * w;
            }
            stack.push(i);
        }
        return water;
        */
    }
}
