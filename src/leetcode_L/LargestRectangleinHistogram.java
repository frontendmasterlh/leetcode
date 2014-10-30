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
        for (int i=0; i <= n; i++){//���Ҫ����������stack���Ԫ����һ�Σ�����Ҫ���һ�Ρ�
            int cur = (i==n) ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {//����stack�������ݵ�����
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
