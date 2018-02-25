package google;

public class BestTimeToBuySellStock4 {
	int maxProfit(int k, vector<int>& prices) {
        if(prices.empty() || k==0)
            return 0;
        if(k > prices.size()/2){
            int maxprofit = 0;
            for(int i=0; i<prices.size()-1; i++){
                if(prices[i] < prices[i+1])
                    maxprofit += prices[i+1] - prices[i];
            }
            return maxprofit;
        }
        
        /*
        int n = prices.size();
        int buy[n][k];
        int sell[n][k];
        for(int i=0; i<k; i++){
            buy[0][i] = INT_MIN;
            sell[0][i] = INT_MIN;
        }
        buy[0][0] = -prices[0];
        for(int i = 1; i<n; i++){
            buy[i][0] = max(buy[i-1][0], -prices[i]);
            sell[i][0] = sell[i-1][0];
            if(buy[i-1][0] != INT_MIN)
                sell[i][0] = max(sell[i][0], buy[i-1][0] + prices[i]);
            for(int j= 1; j<k; j++){
                buy[i][j] = buy[i-1][j];
                if(sell[i-1][j-1] != INT_MIN)
                    buy[i][j] = max(buy[i][j], sell[i-1][j-1] - prices[i]);
                sell[i][j] = sell[i-1][j];
                if(buy[i-1][j] != INT_MIN)
                    sell[i][j] = max(sell[i][j], buy[i-1][j] + prices[i]);
            }
        }
        int maxprofit = 0;
        for(int i=0; i<k; i++){
            maxprofit = max(maxprofit, buy[n-1][i]);
            maxprofit = max(maxprofit, sell[n-1][i]);
        }
        return maxprofit;
        */
        
        // another DP approach
        int n = prices.size();
        int f[n][k];
        for(int j=0; j<k; j++){
            f[0][j] = 0;
            int premax = -prices[0];
            for(int i=1; i<n; i++){
                f[i][j] = f[i-1][j];
                f[i][j] = max(f[i][j], premax + prices[i]);
                if(j>0)
                    premax = max(premax, f[i][j-1]-prices[i]);
                else
                    premax = max(premax, -prices[i]);
            }
        }
        int maxprofit = 0;
        for(int i=0; i<k; i++)
            maxprofit = max(maxprofit, f[n-1][i]);
        return maxprofit;
    }

}
