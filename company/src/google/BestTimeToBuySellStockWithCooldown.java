package google;

class BestTimeToBuySellStockWithCooldown {
   int maxProfit(vector<int>& prices) {
        if(prices.empty())
            return 0;
        vector<int> sell(prices.size(), INT_MIN);
        vector<int> buy(prices.size(), INT_MIN);
        vector<int> colldown(prices.size(),INT_MIN);
        buy[0] = -prices[0];
        colldown[0] = 0;
        for(int i=1; i<prices.size(); i++){
            sell[i] = max(sell[i-1], buy[i-1]+prices[i]);
            buy[i] = max(buy[i-1], colldown[i-1] - prices[i]);
            colldown[i] = max(sell[i-1], colldown[i-1]);
        }
        return max(colldown[prices.size()-1], max(sell[prices.size()-1], buy[prices.size()-1]));

    }
}
