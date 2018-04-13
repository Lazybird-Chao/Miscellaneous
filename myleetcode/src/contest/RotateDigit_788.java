package contest;

public class RotateDigit_788 {
	 /*
    bool escapeGhosts(vector<vector<int>>& ghosts, vector<int>& target) {
        if(target.empty())
            return false;
        if(ghosts.empty())
            return true;
        unordered_set<int> gh_pos;
        for(int i=0; i<ghosts.size(); i++){
            gh_pos.insert(ghosts[i][0]*10000+ghosts[i][1]);
        }
        deque<pair<int, int>> q;
        unordered_set<int> accessed;
        q.push_back(make_pair(target[0], target[1]));
        accessed.insert(target[0]*10000+target[1]);
        int x_n[4] = {0,0,1,-1};
        int y_n[4] = {1,-1,0,0};
        while(!q.empty()){
            pair<int, int> cur = q.front();
            q.pop_front();
            for(int i=0; i<4; i++){
                int xx = cur.first + x_n[i];
                int yy = cur.second + y_n[i];
                if(valid(xx, yy) && accessed.count(xx*10000+yy)==0){
                    if(gh_pos.count(xx*10000+yy)!=0)
                        return false;
                    else if(xx==0 & yy==0)
                        return true;
                    else{
                        q.push_back(make_pair(xx, yy));
                        accessed.insert(xx*10000+yy);
                    }
                }
            }
        }
        return false;
    }
    */
    bool escapeGhosts(vector<vector<int>>& ghosts, vector<int>& target) {
        if(target.empty())
            return false;
        if(ghosts.empty())
            return true;
        int distance = abs(target[0]) + abs(target[1]);
        for(int i=0; i<ghosts.size(); i++){
            int x = ghosts[i][0];
            int y = ghosts[i][1];
            int tmp = abs(x-target[0]) + abs(y-target[1]);
            if(tmp <= distance)
                return false;
        }
        return true;
    }

}
