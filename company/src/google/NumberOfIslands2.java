package google;

public class NumberOfIslands2 {
	vector<int> numIslands2(int m, int n, vector<pair<int, int>>& positions) {
        if(positions.empty())
            return vector<int>();
        int count = 0;
        vector<vector<int>> farthers(m, vector<int>(n, -1));
        vector<int> res;
        for(int i=0; i<positions.size(); i++){
            pair<int, int> cur = positions[i];
            if(cur.first+1<m && farthers[cur.first+1][cur.second] != -1){
                int up_f = find(make_pair(cur.first+1, cur.second), farthers);
                farthers[cur.first][cur.second] = up_f;
            }else{
                farthers[cur.first][cur.second] = cur.first*n + cur.second;
                count++;
            }
            int cur_f = find(cur, farthers);
            if(cur.first-1>=0 && farthers[cur.first-1][cur.second] != -1){
                int down_f = find(make_pair(cur.first-1, cur.second), farthers);
                if(down_f != cur_f){
                    farthers[down_f/n][down_f%n] = cur_f;
                    count--;
                }
            }
            if(cur.second+1<n && farthers[cur.first][cur.second+1]!=-1){
                int right_f = find(make_pair(cur.first, cur.second+1), farthers);
                if(right_f != cur_f){
                    farthers[right_f/n][right_f%n] = cur_f;
                    count--;
                }
            }
            if(cur.second-1>=0 && farthers[cur.first][cur.second-1] != -1){
                int left_f = find(make_pair(cur.first, cur.second-1), farthers);
                if(left_f != cur_f){
                    farthers[left_f/n][left_f%n] = cur_f;
                    count--;
                }
            }
            res.push_back(count);
        }
        return res;
    }
    
    int find(pair<int, int> point, vector<vector<int>>& farthers){
        int f = farthers[point.first][point.second];
        int cols = farthers[0].size();
        if(f != point.first*cols+point.second){
            point.first = f/cols;
            point.second = f%cols;
            f = find(point, farthers);
            farthers[point.first][point.second] = f;
        }
        return f;
    }

}
