package leetcode_L;

import java.util.*;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
        if (height==null || height.length==0)
            return 0;
        Stack<Integer> stack = new Stack<Integer> ();
        //stack.push(height[0]);
        int max = 0;
        int n = height.length;
        for (int i=0; i <= n; i++){//最后要把所有留在stack里的元素清一次，故需要多加一次。
            int cur = (i==n) ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {//保持stack里面数据递增。
                int h = height[stack.pop()];
                int w = (stack.isEmpty() ? i : i-stack.peek()-1);
                max = Math.max( h *w, max);
            }
            stack.push(i);
        }
        return max;
    }
	
	static public void main (String argv[]) {
		;
	}
}
