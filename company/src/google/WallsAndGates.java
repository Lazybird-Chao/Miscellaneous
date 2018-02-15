package google;

public class WallsAndGates {
	/*
    void wallsAndGates(vector<vector<int>>& rooms) {
        if(rooms.empty() || rooms[0].empty())
            return;
        for(int i=0; i<rooms.size(); i++){
            for(int j=0; j<rooms[0].size(); j++){
                if(rooms[i][j]==INT_MAX)
                    bfs(rooms, i, j);
            }
        }
        return;
        
    }
    void bfs(vector<vector<int>>& rooms, int r, int c){
        int i_n[4] = {0,0,1,-1};
        int j_n[4] = {1,-1,0,0};
        vector<vector<int>> accessed(rooms.size(), vector<int>(rooms[0].size(), 0));
        deque<int> q1;
        deque<int> q2;
        q1.push_back(r);
        q2.push_back(c);
        accessed[r][c] = 1;
        int count = 0;
        while(!q1.empty()){
            count++;
            int size = q1.size();
            int i=0;
            for(; i<size; i++){
                int cur_i = q1.front();
                q1.pop_front();
                int cur_j = q2.front();
                q2.pop_front();
                int k=0;
                for(; k<4;  k++){
                    int ii = cur_i+i_n[k];
                    int jj = cur_j + j_n[k];
                    if(isValid(rooms, ii, jj) && accessed[ii][jj]==0){
                        if(rooms[ii][jj]>0){
                            q1.push_back(ii);
                            q2.push_back(jj);
                            accessed[ii][jj] = 1;
                        }else if(rooms[ii][jj] == 0){
                            rooms[r][c] = count;
                            return;
                        }
                    }
                }
            }
        }
        return;
 
    }
    bool isValid(vector<vector<int>>& rooms, int i, int j){
        if(i<0 || i>=rooms.size() || j<0 || j>= rooms[0].size())
            return false;
        return true;
    }
    */
    void wallsAndGates(vector<vector<int>>& rooms) {
        if(rooms.empty() || rooms[0].empty())
            return;
        int i_n[4] = {0,0,1,-1};
        int j_n[4] = {1,-1,0,0};
        deque<int> row;
        deque<int> col;
        vector<vector<int>> accessed(rooms.size(), vector<int>(rooms[0].size(), 0));
        for(int i=0; i<rooms.size(); i++){
            for(int j=0; j<rooms[0].size(); j++){
                if(rooms[i][j] == 0){
                    row.push_back(i);
                    col.push_back(j);
                    accessed[i][j] = 1;
                }
            }
        }
        int count = 0;
        while(!row.empty()){
            count++;
            int size = row.size();
            for(int i=0; i<size; i++){
                int cur_i = row.front();
                row.pop_front();
                int cur_j = col.front();
                col.pop_front();
                for(int k=0; k<4; k++){
                    int ii = cur_i+i_n[k];
                    int jj = cur_j+j_n[k];
                    if(isValid(rooms, ii, jj) && accessed[ii][jj]==0){
                        if(rooms[ii][jj] == INT_MAX){
                            rooms[ii][jj] = count;
                            row.push_back(ii);
                            col.push_back(jj);
                        }
                        accessed[ii][jj] = 1;
                    }
                }
            }
        }
        return;
    }
    bool isValid(vector<vector<int>>& rooms, int i, int j){
        if(i<0 || i>=rooms.size() || j<0 || j>= rooms[0].size())
            return false;
        return true;
    }
    

}
