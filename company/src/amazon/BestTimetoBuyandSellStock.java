package amazon;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length ==0)
			return 0;
		int maxprofit = 0;
		int minsell = prices[0];
		for(int i=0; i<prices.length; i++) {
			if(maxprofit < prices[i] - minsell)
				maxprofit = prices[i] - minsell;
			if(prices[i] < minsell)
				minsell = prices[i];
		}
		return maxprofit;
	}

}
