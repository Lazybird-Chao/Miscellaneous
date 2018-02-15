package google;

public class ShortesDistanceFromAllBuilding {
	int shortestDistance(vector<vector<int>>& grid) {
        if(grid.empty() || grid[0].empty())
            return -1;
        int m = grid.size();
        int n = grid[0].size();
        int totalone = 0;
        unordered_map<int, int> distance;
        unordered_map<int, int> reachCount;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    totalone++;
                else if(grid[i][j]==0){
                    distance[i*n + j] = 0;
                    reachCount[i*n +j] = 0;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1)
                    bfs(grid, i, j, distance, reachCount);
            }
        }
        int mindis = INT_MAX;
        for(auto &it : reachCount){
            if(it.second == totalone){
                mindis = min(mindis, distance[it.first]);
            }
        }
        if(mindis == INT_MAX)
            return -1;
        else
            return mindis;
        
    }
    
    void bfs(vector<vector<int>>& grid, int i, int j, unordered_map<int, int> &distance, unordered_map<int, int> &reachCount){
        int i_next[4] = {1,-1,0,0};
        int j_next[4] = {0,0,1,-1};
        vector<vector<int>> accessed(grid.size(), vector<int>(grid[0].size(), 0));
        int m = grid.size();
        int n = grid[0].size();
        deque<int> q;
        q.push_back(i*n + j);
        accessed[i][j] = 1;
        int dis = 0;
        while(!q.empty()){
            int cur_size = q.size();
            dis++;
            for(int i=0; i<cur_size; i++){
                int cur_i = q.front()/n;
                int cur_j = q.front() %n;
                q.pop_front();
                for(int j=0; j<4; j++){
                    int ii = cur_i + i_next[j];
                    int jj = cur_j + j_next[j];
                    if(isValid(grid, ii, jj) && accessed[ii][jj]==0){
                        if(grid[ii][jj] == 0){
                            distance[ii*n+jj] += dis;
                            reachCount[ii*n+jj] += 1;
                            q.push_back(ii*n + jj);
                        }
                        accessed[ii][jj] = 1;
                    }
                }
            }
        }
        return;
    }
    
    bool isValid(vector<vector<int>>& grid, int i, int j){
        if(i<0 || i>= grid.size() || j<0 || j>= grid[0].size())
            return false;
        return true;
    }

}
