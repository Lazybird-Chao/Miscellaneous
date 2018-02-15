package google;

public class Maze2 {
	int shortestDistance(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
        if(maze.empty() || maze[0].empty())
            return -1;
        vector<vector<int>> visited(maze.size(), vector<int>(maze[0].size(), 0));
        vector<vector<int>> distance(maze.size(), vector<int>(maze[0].size(), INT_MAX));
        vector<pair<int, int>> q;
        q.push_back(make_pair(start[0], start[1]));
        visited[start[0]][start[1]] = 1;
        distance[start[0]][start[1]] = 0;
        int x_n[4] = {1,-1,0,0};
        int y_n[4] = {0,0,1,-1};
        while(!q.empty()){
            int min_pos = 0;
            for(int i=1; i<q.size(); i++){
                if(distance[q[min_pos].first][q[min_pos].second] > distance[q[i].first][q[i].second])
                    min_pos = i;
            }
            pair<int, int> cur = q[min_pos];
            q.erase(q.begin() + min_pos);
            if(cur.first == destination[0] && cur.second == destination[1])
                break;
            //visited[cur.first][cur.second] = 1;
            for(int i=0; i<4; i++){
                int xx = cur.first + x_n[i];
                int yy = cur.second + y_n[i];
                int step = 0;
                while(isValid(maze, xx, yy) && maze[xx][yy]==0){
                    step++;
                    xx += x_n[i];
                    yy += y_n[i];
                }
                xx -= x_n[i];
                yy -= y_n[i];
                if(visited[xx][yy] == 0){
                    q.push_back(make_pair(xx, yy));
                    visited[xx][yy] = 1;
                }
                distance[xx][yy] = min(distance[xx][yy], distance[cur.first][cur.second]+step);
            }
        }
        if(distance[destination[0]][destination[1]] == INT_MAX)
            return -1;
        return distance[destination[0]][destination[1]];
    }
    bool isValid(vector<vector<int>>& maze, int x, int y){
        if(x<0 || x>=maze.size() || y<0 || y>=maze[0].size())
            return false;
        return true;
    }

}
