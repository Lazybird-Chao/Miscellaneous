package contest;

public class SwimInRisingWater_778 {
	class mycomp{
	    public:
	        bool operator()(const pair<pair<int, int>, int>& a, const pair<pair<int,int>, int>& b){
	            return a.second > b.second;
	        }
	    };
	    int swimInWater(vector<vector<int>>& grid) {
	        if(grid.empty() || grid[0].empty())
	            return 0;
	        int m = grid.size();
	        int n = grid[0].size();
	        int dp[m][n];
	        for(int i=0; i<m; i++)
	            for(int j=0; j<n; j++)
	                dp[i][j] = -1;
	        using Node = pair<pair<int, int>, int>;
	        priority_queue<pair<pair<int, int>, int>, vector<pair<pair<int,int>,int>>, mycomp> q;
	        q.push(make_pair(make_pair(0,0), grid[0][0]));
	        dp[0][0] = grid[0][0];
	        int r_n[4] = {0,0,1,-1};
	        int c_n[4] = {1,-1,0,0};
	        while(!q.empty()){
	            Node cur = q.top();
	            q.pop();
	            //cout<<cur.second<<endl;
	            pair<int, int> pos = cur.first;
	            int val = cur.second;
	            if(pos.first == m-1 && pos.second == n-1)
	                break;
	            if(dp[pos.first][pos.second]!= -1 && dp[pos.first][pos.second] < val)
	                continue;
	            for(int i=0; i<4; i++){
	                int ii = pos.first+r_n[i];
	                int jj = pos.second+c_n[i];
	                if(isValid(m, n, ii, jj)){
	                    int tmp = max(dp[pos.first][pos.second], grid[ii][jj]);
	                    if(dp[ii][jj] == -1 || dp[ii][jj]>tmp){
	                        dp[ii][jj] = tmp;
	                        q.push(make_pair(make_pair(ii, jj), tmp));
	                    }
	                }
	            }
	        }
	        return dp[m-1][n-1];
	        
	    }
	    bool isValid(int m, int n, int i, int j){
	        if(i<0 || i>=m || j<0 || j>=n)
	            return false;
	        return true;
	    }

}
