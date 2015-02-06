package leetcode_B;

public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0)
            return 0;
        int res = 0;
        for (int i=1; i< prices.length; i++) {
            if (prices[i] > prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
	
	static public void main (String[] argv) {
		int[] prices = {1,3,7,2,8,4,6,1};
		System.out.println(new BestTimetoBuyandSellStockII().maxProfit(prices));
	}
}
