package google;

public class Maze3 {
	string findShortestWay(vector<vector<int>>& maze, vector<int>& ball, vector<int>& hole) {
        if(maze.empty() || maze[0].empty())
            return "impossible";
        vector<vector<int>> distance(maze.size(), vector<int>(maze[0].size(), INT_MAX));
        vector<vector<int>> visited(maze.size(), vector<int>(maze[0].size(), 0));
        vector<pair<int, int>> q;
        vector<vector<pair<int, int>>> prepos(maze.size(), vector<pair<int, int>>(maze[0].size()));
        
        int x_n[4] = {1, 0, 0, -1};
        int y_n[4] = {0, -1, 1, 0};
        q.push_back(make_pair(ball[0], ball[1]));
        visited[ball[0]][ball[1]] = 1;
        distance[ball[0]][ball[1]] = 0;
        string minpath = "";
        while(!q.empty()){
            int min_pos = 0;
            for(int i=1; i<q.size(); i++){
                if(distance[q[min_pos].first][q[min_pos].second] > distance[q[i].first][q[i].second])
                    min_pos = i;
            }
            pair<int, int> cur = q[min_pos];
            q.erase(q.begin() + min_pos);
            for(int i=0; i<4; i++){
                int xx = cur.first + x_n[i];
                int yy = cur.second + y_n[i];
                int step = 0;
                while(isValid(maze, xx, yy) && maze[xx][yy] != 1){
                    step++;
                    if(xx == hole[0] && yy == hole[1])
                        break;
                    xx += x_n[i];
                    yy += y_n[i];
                }
                if(xx != hole[0] || yy != hole[1]){
                    xx -= x_n[i];
                    yy -= y_n[i];
                }
                if(step==0)
                    continue;
                int tmp = distance[cur.first][cur.second] + step;
                //cout<<distance[xx][yy]<<" "<<tmp<<endl;
                if(distance[xx][yy] > tmp){
                    distance[xx][yy] = tmp;
                    prepos[xx][yy] = cur;
                }else if(distance[xx][yy] == tmp){
                    string s1 = getPath(prepos, make_pair(ball[0], ball[1]), make_pair(xx, yy));
                    //cout<<s1<<endl;
                    pair<int, int> pre = prepos[xx][yy];
                    prepos[xx][yy] = cur;
                    string s2 = getPath(prepos, make_pair(ball[0], ball[1]), make_pair(xx, yy));
                    if(s1 < s2)
                        prepos[xx][yy] = pre;
                }
                if(xx == hole[0] && yy == hole[1])
                    continue;
                if(visited[xx][yy] == 0){
                    q.push_back(make_pair(xx, yy));
                    visited[xx][yy] = 1;
                }
            }
        }
        //cout<<distance[hole[0]][hole[1]]<<endl;
        if(distance[hole[0]][hole[1]] == INT_MAX)
            return "impossible";
        else
            return getPath(prepos, make_pair(ball[0], ball[1]), make_pair(hole[0], hole[1]));
        
        
    }
    string getPath(vector<vector<pair<int, int>>>& prepos, pair<int, int>&& ball, pair<int, int>&& hole){
        string res = "";
        pair<int, int> pre = prepos[hole.first][hole.second];
        pair<int, int> cur= hole;
        while(pre.first != ball.first || pre.second != ball.second){
            //cout<<pre.first<<" "<<pre.second<<endl;
            if(pre.first == cur.first)
                res += pre.second-cur.second > 0 ? 'l' : 'r';
            else if(pre.second == cur.second)
                res += pre.first-cur.first >0 ? 'u' : 'd';
            cur = pre;
            pre = prepos[cur.first][cur.second];
        }
        if(pre.first == cur.first)
            res += pre.second-cur.second > 0 ? 'l' : 'r';
        else if(pre.second == cur.second)
            res += pre.first-cur.first >0 ? 'u' : 'd';
        reverse(res.begin(), res.end());
        return res;
    }
    bool isValid(vector<vector<int>>& maze, int x, int y){
        if(x<0 || x>=maze.size() || y<0 || y>=maze[0].size())
            return false;
        return true;
    }

}
