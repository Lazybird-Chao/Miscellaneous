package myleetcode;

public class BestTime2BuySellStock2 {
	public int maxProfit(int[] prices){
		int profit = 0;
		int buy, sell;
		buy = sell = 0;
		int i=0;
		while(i<prices.length){
			while(i<prices.length-1 && prices[i]<=prices[i+1]){
				i++;
			}
			sell = i;
			profit += prices[sell] - prices[buy];
			i++;
			while(i<prices.length-1 && prices[i]>prices[i+1]){
				i++;
			}
			buy = i;
			i++;
		}
		return profit;
	}
}
