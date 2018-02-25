package google;

public class BestTimeToBuySellStock3 {
	int maxProfit(vector<int>& prices) {
        if(prices.empty())
            return 0;
        int fsell[prices.size()][2];
        int fbuy[prices.size()][2];
        fsell[0][0] = fsell[0][1] = INT_MIN;
        fbuy[0][1] = INT_MIN;
        fbuy[0][0] = -prices[0];
        for(int i=1; i<prices.size(); i++){
            fbuy[i][0] = max(fbuy[i-1][0], -prices[i]);
            fbuy[i][1] = fbuy[i-1][1];
            if(fsell[i-1][0] != INT_MIN)
                fbuy[i][1] = max(fbuy[i][1], fsell[i-1][0] - prices[i]);
            fsell[i][0] = fsell[i-1][0];
            if(fbuy[i-1][0] != INT_MIN)
                fsell[i][0] = max(fsell[i][0], fbuy[i-1][0] + prices[i]);
            fsell[i][1] = fsell[i-1][1];
            if(fbuy[i-1][1] != INT_MIN)
                fsell[i][1] = max(fsell[i][1], fbuy[i-1][1] + prices[i]);
                
        }
        int maxprofit = 0;
        int n = prices.size();
        maxprofit = max(maxprofit, fbuy[n-1][0]);
        maxprofit = max(maxprofit, fbuy[n-1][1]);
        maxprofit = max(maxprofit, fsell[n-1][0]);
        maxprofit = max(maxprofit, fsell[n-1][1]);
        return maxprofit;
    }

}
