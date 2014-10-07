package leetcode_M;

public class MaximumProductSubarray {
	private static int[] A = {2,7,-2,4};
	
	public int maxProduct(int[] A) {
        int n = A.length;
        int mintemp = A[0];
        int maxtemp = A[0];
        int result = A[0];
        
        for (int i=1; i< n; i++){
            int a = mintemp * A[i]; 
            int b = maxtemp * A[i];
            int c = A[i];
            mintemp = Math.min (Math.min(a,b), c);
            maxtemp = Math.max (Math.max(a,b), c);
            result = Math.max (result, maxtemp);
        }
        return result;
        
        // int n = A.length;//大集合超时。
        // int[][] f = new int[n][n]; 
        // f[0][0] = A[0];
        // int maxNum = Integer.MIN_VALUE;
        // for (int i=1; i< n; i++){
        //     f[i][i] = A[i];
        //     f[0][i] = f[0][i-1] * A[i];
        //     maxNum = Math.max(maxNum, A[i]);
        //     maxNum = Math.max(maxNum, f[0][i]);
        // }
        
        // for (int i=0; i<n; i++){
        //     for (int j=i+1; j< n; j++){
        //         f[i][j] = f[i][j-1] *A[j];
        //         maxNum = Math.max (maxNum, f[i][j]);
        //     }
        // }
        // return maxNum;
    }
	
	static public void main (String argv[]){
		System.out.println(new MaximumProductSubarray ().maxProduct(A));
	}
}
