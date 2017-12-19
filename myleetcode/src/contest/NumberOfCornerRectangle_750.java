package contest;

public class NumberOfCornerRectangle_750 {
	 /*
    int countCornerRectangles(vector<vector<int>>& grid) {
        if(grid.empty() || grid[0].empty())
            return 0;
        int count = 0;
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                int tmp = 0;
                if(grid[i][j] != 0)
                   tmp = formRec(grid, i, j);
                count += tmp;
                //cout<<tmp<<endl;
            }
        }
        return count;
    }
    
    int formRec(vector<vector<int>>& grid, int starti, int startj){
        int count = 0;
        for(int i = starti+1; i<grid.size(); i++){
            if(grid[i][startj] == 0)
                continue;
            for(int j=startj+1; j<grid[0].size(); j++){
                if(grid[i][j] != 0 && grid[starti][j] !=0)
                    count++;
            }
        }
        return count;
    }
    */
    int countCornerRectangles(vector<vector<int>>& grid) {
        if(grid.empty() || grid[0].empty())
            return 0;
        int count = 0;
        for(int i=0; i<grid.size()-1; i++){
            for(int j=i+1; j<grid.size(); j++)
                count += formRec(grid, i, j);
        }
        return count;
    }
    
    int formRec(vector<vector<int>>& grid, int i1, int i2){
        int count = 0;
        int precount  = -1;
        for(int j = 0; j<grid[0].size(); j++){
            if(grid[i1][j] == 1 && grid[i2][j] == 1){
                precount += 1;
                count += precount;
            }
        }
        return count;
    }

}
