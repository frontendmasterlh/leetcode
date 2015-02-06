package leetcode_C;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        if (height==null || height.length==0){
            return 0;
        }
        int i = 0, j = height.length - 1;
        int res = Integer.MIN_VALUE, temp = 0;
        while (i < j){
            temp = (j - i) * (Math.min(height[i], height[j]));
            if (res < temp) {
                res = temp;
            }else if (height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }
	
	static public void main (String[] argv) {
		;
	}
}
