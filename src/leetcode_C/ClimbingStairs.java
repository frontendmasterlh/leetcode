package leetcode_C;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n==0)
            return 0;
        int[] dp = new int[n+1];//It defines the number of way of ith stair
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    static public void main (String[] argv){
    	int n = 6;
    	System.out.println(new ClimbingStairs().climbStairs(n));
    }
}