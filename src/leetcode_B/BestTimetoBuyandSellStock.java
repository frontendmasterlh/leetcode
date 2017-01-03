package leetcode_B;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
        if (prices==null || prices.length == 0)
            return 0;
        int min = prices[0];
        int res = 0;
        for (int i= 1; i< prices.length; i++) {
            if (min > prices[i]){
                min = prices[i];
            }else if (res < prices[i] - min){
                res = prices[i] - min;
            }
        }
        return res;
    }
	
	static public void main (String[] argv) {
		int[] prices = {1,3,7,2,8,4,6,1};
		System.out.println(new BestTimetoBuyandSellStock().maxProfit(prices));
	}
}
