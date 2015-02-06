package leetcode_B;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)
            return 0;

        int[] A = new int[prices.length];
        int[] B = new int[prices.length];
        
        A[0] = 0;
        B[prices.length-1] = 0;
        
        int min = prices[0];
        for (int i=1; i< prices.length; i++){
            A[i] = prices[i] - min > A[i -1] ? prices[i] - min : A[i -1];
            min = min >prices[i] ? prices[i] : min;
        }
        
        int max = prices[prices.length - 1];
        for (int i = prices.length -2; i>=0; i--){
            B[i] = max - prices[i] > B[i+1] ? max - prices[i] : B[i + 1];
            max = max < prices[i] ? prices[i] : max;
        }

        int res = 0;        
        for (int i=0; i< prices.length; i++) {
            if (res < A[i] + B[i]){
                res = A[i] + B[i];
            }
        }
        return res;
    }
	
	static public void main (String[] argv) {
		int[] prices = {1,3,7,2,8,4,6,1};
		System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(prices));;
	}
}
