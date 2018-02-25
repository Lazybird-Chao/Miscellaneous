package contest;

public class CheapestFlightWihinKstops_787 {
	int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int K) {
        if(flights.empty())
            return -1;
        vector<vector<int>> costs(n, vector<int>(n, -1));
        for(int i=0; i<flights.size(); i++){
            costs[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        vector<vector<int>> f(2, vector<int>(n, INT_MAX));
        for(int i=0; i<n; i++){
            if(costs[src][i] != -1)
                f[0][i] = costs[src][i];
        }
        int mincost = INT_MAX;
        mincost = min(mincost, f[0][dst]);
        int flag = 0;
        for(int k=1; k<=K; k++){
            int next_flag= (flag+1)%2;
            for(int i=0; i<n; i++){
                if(f[flag][i] != INT_MAX){
                    for(int j=0; j<n; j++){
                        if(costs[i][j] != -1)
                            f[next_flag][j] = min(f[next_flag][j], f[flag][i] + costs[i][j]);
                    }
                    f[flag][i] = INT_MAX;
                }
            }
            mincost = min(mincost, f[next_flag][dst]);
            flag = next_flag;
        }
        if(mincost == INT_MAX)
            return -1;
        else
            return mincost;
    }

}
