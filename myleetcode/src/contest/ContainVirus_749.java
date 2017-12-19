package contest;

public class ContainVirus_749 {
	int containVirus(vector<vector<int>>& grid) {
        if(grid.empty() || grid[0].empty())
            return 0;
        int totalWalls = 0;
        unordered_set<int> walledOnePos;
        vector<vector<int>> access(grid.size(), vector<int>(grid[0].size(),  0));
        vector<vector<int>> newgrid(grid.size(), vector<int>(grid[0].size(),  0));
        int maxInfectCell = 0;
        vector<int>* maxRegion = nullptr;
        int maxRegionWalls = 0;
        vector<vector<int>> *curgrid = &grid;
        vector<vector<int>> *nextgrid = &newgrid;
        
        while(true){
            for(int i=0; i<grid.size(); i++){
                for(int j=0; j<grid[0].size(); j++){
                    if(access[i][j] != 0 || (*curgrid)[i][j] ==0)
                        continue;
                    if(walledOnePos.find(i*grid[0].size() + j) != walledOnePos.end())
                        continue;
                    int infectCell = 0;
                    int walls = 0;
                    vector<int> *region = new vector<int>();
                    infectCell = bfs(*curgrid, i, j, access, region, walls, walledOnePos);
                    //cout<<infectCell<<endl;
                    if(infectCell>maxInfectCell){
                        maxInfectCell = infectCell;
                        maxRegionWalls = walls;
                        maxRegion = region;
                    }
                }
            }
        
            if(maxRegion != nullptr){
                //cout<<maxRegionWalls<<" "<<maxRegion->size()<<endl;
                for(int i=0; i<maxRegion->size(); i++)
                    walledOnePos.insert((*maxRegion)[i]);
                delete maxRegion;
                maxRegion = nullptr;
                totalWalls += maxRegionWalls;
                infectStep(*curgrid, *nextgrid, access, walledOnePos);
                vector<vector<int>> *tmp = nextgrid;
                nextgrid = curgrid;
                curgrid = tmp;
                maxRegionWalls = 0;
                maxInfectCell = 0;
            }else
                break;
        }
        return totalWalls;
    }
    
    void infectStep(vector<vector<int>>& grid, vector<vector<int>>& newgrid, vector<vector<int>>& access, unordered_set<int>& walledOnePos){
        int i_next[4] = {0,0,1,-1};
        int j_next[4] = {1,-1,0,0};
        for(int i=0; i<grid.size(); i++)
            for(int j=0; j<grid[0].size(); j++)
                newgrid[i][j] = 0;
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                access[i][j] = 0;
                if(grid[i][j]==1)
                    newgrid[i][j] = 1;
                if(walledOnePos.find(i*grid[0].size()+j) == walledOnePos.end() && grid[i][j]==1){
                    for(int k=0; k<4; k++){
                        int tmpi = i+i_next[k];
                        int tmpj = j+j_next[k];
                        if(tmpi<0 || tmpi>=grid.size() || tmpj <0 || tmpj>=grid[0].size())
                            continue; 
                        newgrid[tmpi][tmpj] = 1;
                    }
                }
            }
        }
    }
    
    int bfs(vector<vector<int>>& grid, int i, int j, vector<vector<int>>& access,
            vector<int> *posOfOne, int &neededWall, unordered_set<int>& walledOnePos){
        int w = grid[0].size();
        int h = grid.size();
        int i_next[4] = {0,0,1,-1};
        int j_next[4] = {1,-1,0,0};
        unordered_set<int> zeroCount;
        queue<int> q;
        q.push(i*w+j);
        access[i][j] = 1;
        posOfOne->push_back(i*w+j);
        while(!q.empty()){
            int curpos = q.front();
            q.pop();
            int ii = curpos/w;
            int jj = curpos % w;
            for(int k = 0; k<4; k++){
                int tmpi = ii+i_next[k];
                int tmpj = jj+j_next[k];
                if(tmpi<0 || tmpi>=h || tmpj <0 || tmpj>=w)
                    continue;
                int tmp_pos = tmpi*w+tmpj;
                if(walledOnePos.find(tmp_pos) != walledOnePos.end())
                    continue;
                if(access[tmpi][tmpj]==0 && grid[tmpi][tmpj]==1){
                    q.push(tmp_pos);
                    access[tmpi][tmpj] = 1;
                    posOfOne->push_back(tmp_pos);
                }else if(grid[tmpi][tmpj] == 0){
                    zeroCount.insert(tmp_pos);
                    neededWall++;
                }
            }
        }
        return zeroCount.size();   
    }

}
