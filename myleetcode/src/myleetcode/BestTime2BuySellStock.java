package myleetcode;

public class BestTime2BuySellStock {
	public int maxProfit(int[] prices){
		int small, large;
		small = large = 0;
		int profit = 0;
		for(int i=0; i<prices.length; i++){
			if(prices[i]>prices[large]){
				large = i;
				int tmp = prices[large]-prices[small];
				if(tmp > profit)
					profit = tmp;
			}
			else if(prices[i]<prices[small]){
				small = large = i;
			}
		}
		return profit;
	}
}
