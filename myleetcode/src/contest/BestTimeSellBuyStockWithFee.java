package contest;

public class BestTimeSellBuyStockWithFee {
	public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length ==0)
            return 0;
        int[] unhold = new int[prices.length];
        int[] hold = new int[prices.length];
        unhold[0] = 0;
        hold[0] = -prices[0]-fee;
        for(int i = 1; i < prices.length; i++){
            unhold[i] = unhold[i-1];
            unhold[i] = Math.max(hold[i-1] + prices[i], unhold[i]);
            hold[i] = hold[i-1];
            hold[i] = Math.max(unhold[i-1] - prices[i]-fee, hold[i]);
        }
 
        return unhold[prices.length-1];
    }

}
