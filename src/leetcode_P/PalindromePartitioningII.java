package leetcode_P;

public class PalindromePartitioningII {
boolean[][] dp;
    
    // private boolean isPalindrome (String s, int i, int j) {//Time Limit Exceeded
    //     if (i> j)
    //         return false;
    //     if (i==j){
    //         return dp[i][j]=true;
    //     }
    //     if (s.charAt(i)!=s.charAt(j))
    //         return dp[i][j]=false;
    //     else {
    //         if (j == i+1)
    //             return dp[i][j]=true;
    //         else
    //             return dp[i][j] = isPalindrome(s, i+1, j-1);
    //     }
    // }
    
    // public int minCut(String s) {
        // if (s==null || s.length()==0 || s.length()==1)
        //     return 0;
        // int n = s.length();
        // dp = new boolean[n][n];
    //     int[] min = new int[n];
    //     for (int i=0; i<n; i++) {
    //         min[i] = 0;
    //         for (int j=0; j < n; j++) {
    //             dp[i][j] = false;
    //         }
    //     }
    //     int temp, ans;
    //     for (int i =1; i< n; i++) {
    //         if (isPalindrome(s, 0, i)){
    //             min[i] = 0;
    //         }else {
    //             ans = n+1;
    //             for (int k = 0; k <i; k++) {
    //                 if (isPalindrome(s, k+1, i))
    //                     temp = min[k] +1;
    //                 else{
    //                     temp = min[k] + i -k;
    //                 }
    //                 if (ans > temp) {
    //                     ans  = temp;
    //                 }
    //             }
    //             min[i] = ans;
    //         }
    //     }
    //     return min[n-1];
    // }
    
    public int minCut(String s) {
        if (s==null || s.length()==0 || s.length()==1)
            return 0; 
        int n = s.length();
        dp = new boolean[n][n];
        int[] count = new int[n+1];
        //System.out.println(count[n]);
        for (int i = n-1; i>=0; i--) {
        	//System.out.println("count["+i+"]="+count[i]);
            count[i] = Integer.MAX_VALUE;
            for (int j=i; j<n; j++) {
                if (s.charAt(i)==s.charAt(j) && (j-i <2 || dp[i+1][j-1]==true)){
                    dp[i][j] = true;
                    //System.out.println("count["+i+"]="+count[i]+", 1 + count["+j+"+1]="+ (1+count[j+1]));
                    count[i] = Math.min(count[j+1]+1, count[i]);
                    //System.out.println("After that count["+i+"] is " +count[i]);
                }
            }
        }
        return count[0] -1;
    }
	
    static public void main (String argv[]){
    	String s="aa";//"amanaplanacanalpanama";//"ab";
    	System.out.println(new PalindromePartitioningII().minCut(s));
    }
}
