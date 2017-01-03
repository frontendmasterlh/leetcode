package leetcode_T;

public class TrappingRainWater {
    public int trap(int[] A) {
        if (A==null || A.length==0)
            return 0;
        int high = 0;
        for (int i=1; i < A.length; i++) {
            if (A[high] < A[i])
                high = i;
        }
        int water = 0;
        int h = 0;
        for (int i =0; i< high; i++) {
            if (h > A[i])
                water += h - A[i];
            else
                h = A[i];
        }
        h = 0;
        for (int i = A.length -1; i > high; i--) {
            if (h > A[i])
                water += h - A[i];
            else 
                h = A[i];
        }
        return water;
    }
    
    static public void main (String[] argv) {
    	int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(new TrappingRainWater().trap(A));
    }
}
