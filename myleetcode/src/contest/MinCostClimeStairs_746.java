package contest;

public class MinCostClimeStairs_746 {
	int minCostClimbingStairs(vector<int>& cost) {
        if(cost.size()<2)
            return 0;
        vector<int> mincost(cost.size()+1);
        mincost[0] = mincost[1] = 0;
        for(int i = 2; i<=cost.size(); i++){
            mincost[i] = min(mincost[i-1]+cost[i-1], mincost[i-2]+cost[i-2]);
        }
        return mincost[cost.size()];
    }

}
