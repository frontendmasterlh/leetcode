package leetcode_M;

public class MaximumSubarray {
	private static int[] A = {-2,1,-3,4,-1,2,1,-5,4};
	
	public int maxSubArray(int[] A) {
        if (A==null || A.length==0)
            return 0;
        int n = A.length;
        int[] B = new int[n];
        B[0] = A[0];
        int max = B[0];
        for (int i=1; i<n; i++) {
            if (A[i] < A[i]+B[i-1])
                B[i] = A[i] + B[i-1];
            else
                B[i] = A[i];
            max = Math.max(max, B[i]);
        }
        return max;
    }
	
	static public void main (String argv[]){
		System.out.println(new MaximumSubarray ().maxSubArray(A));
	}
}
