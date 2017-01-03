package leetcode_M;

public class MaximumSubarray {
	private static int[] A = {-2,1,-3,4,-1,2,1,-5,4};
	private static int[] A2 = {-2,1};
	
	public int maxSubArray(int[] A) {
		//The 1st method: DP Time: O(N)
        if (A == null || A.length == 0)
            return 0;
        int maxsum = A[0], sum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (sum < 0)
                sum = 0;
            sum += A[i];
            System.out.println(sum + "~");
            maxsum = Math.max(maxsum, sum);
            System.out.println(maxsum);
        }
        return maxsum;
		
//        if (A==null || A.length==0)
//            return 0;
//        int n = A.length;
//        int[] B = new int[n];
//        B[0] = A[0];
//        int max = B[0];
//        for (int i=1; i<n; i++) {
//            if (A[i] < A[i]+B[i-1])
//                B[i] = A[i] + B[i-1];
//            else
//                B[i] = A[i];
//            max = Math.max(max, B[i]);
//        }
//        return max;
        
//      //The 2nd method: Divide and Conquer Time: O(NlogN)
//        return findMaxSubArray(A, 0, A.length-1);
    }
	
	private int findMaxSubArray(int[] A, int begin, int end) {
        if (begin == end)
            return A[begin];
        int mid = (begin + end) /2;
        int preMax = findMaxSubArray(A, begin, mid);
        int postMax= findMaxSubArray(A, mid+1, end);
        
        int leftpart = Integer.MIN_VALUE, rightpart = Integer.MIN_VALUE;
        
        int sum = 0;
        for (int i = mid; i >= begin; i--) {
            sum += A[i];
            if (sum > leftpart)
                leftpart = sum;
        } 
        
        sum  =0;
        for (int i = mid+1; i <= end; i++) {
            sum += A[i];
            if (sum > rightpart)
                rightpart = sum;
        }
        
        sum = leftpart + rightpart;
        return Math.max(sum, Math.max(preMax, postMax));
    }
	
	static public void main (String argv[]){
		System.out.println(new MaximumSubarray ().maxSubArray(A2));
	}
}
