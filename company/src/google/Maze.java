package google;

public class Maze {
	bool hasPath(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        if(maze.empty() || maze[0].empty())
            return false;
        vector<vector<int>> explored_dir(maze.size(), vector<int>(maze[0].size(), 0));
        if(dfs(maze, explored_dir, make_pair(start[0], start[1]), 0, make_pair(destination[0], destination[1])))
            return true;
        else if(dfs(maze, explored_dir, make_pair(start[0], start[1]), 1, make_pair(destination[0], destination[1])))
            return true;
        else if(dfs(maze, explored_dir, make_pair(start[0], start[1]), 2, make_pair(destination[0], destination[1])))
            return true;
        else if(dfs(maze, explored_dir, make_pair(start[0], start[1]), 3, make_pair(destination[0], destination[1])))
            return true;
        return false;
        
    }
    bool dfs(vector<vector<int>>& maze, vector<vector<int>>& explored_dir, pair<int, int> cur, int direct, pair<int, int> dst){
        int x_n[4] = {-1,1,0,0};
        int y_n[4] = {0,0,-1,1};
        int xx = cur.first+x_n[direct];
        int yy = cur.second+y_n[direct];
        //cout<<cur.first<<" "<<cur.second<<" "<<explored_dir[cur.first][cur.second]<<endl;
        if(isValid(maze, xx, yy) == false || maze[xx][yy] ==1){
            if(cur.first == dst.first && cur.second == dst.second)
                return true;
            explored_dir[cur.first][cur.second] |= (1<<direct);
            if((explored_dir[cur.first][cur.second] & 1) == 0){
                explored_dir[cur.first][cur.second] |= 1;
                if(isValid(maze, cur.first-1, cur.second) && maze[cur.first-1][cur.second] != 1){
                    if(dfs(maze, explored_dir, make_pair(cur.first-1, cur.second), 0, dst))
                        return true;
                }   
            } 
            if((explored_dir[cur.first][cur.second] & 2) ==0){
                explored_dir[cur.first][cur.second] |= 2;
                if(isValid(maze, cur.first+1, cur.second) && maze[cur.first+1][cur.second] != 1){
                    if(dfs(maze, explored_dir, make_pair(cur.first+1, cur.second), 1, dst))
                        return true;
                }
            } 
            if((explored_dir[cur.first][cur.second] & 4)==0){
                explored_dir[cur.first][cur.second] |= 4;
                if(isValid(maze, cur.first, cur.second-1) && maze[cur.first][cur.second-1] != 1){
                    if(dfs(maze, explored_dir, make_pair(cur.first, cur.second-1), 2, dst))
                        return true;
                }
            } 
            if((explored_dir[cur.first][cur.second] & 8)==0){
                explored_dir[cur.first][cur.second] |= 8;
                if(isValid(maze, cur.first, cur.second+1) && maze[cur.first][cur.second+1] != 1){
                    if(dfs(maze, explored_dir, make_pair(cur.first, cur.second+1), 3, dst))
                        return true;
                }
            }
            return false;
        }else{
            explored_dir[cur.first][cur.second] |= (1<<direct);
            return dfs(maze, explored_dir, make_pair(xx, yy), direct, dst);
        }
    }
    bool isValid(vector<vector<int>>& maze, int i, int j){
        if(i<0 || i>= maze.size() || j<0 || j>=maze[0].size())
            return false;
        return true;
    }

}
