package google;

public class BombEnemy {
	int maxKilledEnemies(vector<vector<char>>& grid) {
        if(grid.empty() || grid[0].empty())
            return 0;
        int m = grid.size();
        int n = grid[0].size();
        int enemy[m][n];
        for(int i=0; i<m; i++){
            int e = 0;
            for(int j=0; j<n; j++){
                if(grid[i][j]=='0')
                    enemy[i][j] = e;
                else if(grid[i][j]=='E')
                    e++;
                else if(grid[i][j]=='W')
                    e=0;
            }
        }
        for(int i=0; i<m; i++){
            int e = 0;
            for(int j=n-1; j>=0; j--){
                if(grid[i][j]=='0')
                    enemy[i][j] += e;
                else if(grid[i][j]=='E')
                    e++;
                else if(grid[i][j]=='W')
                    e=0;
            }
        }
        for(int i=0; i<n; i++){
            int e = 0;
            for(int j=0; j<m; j++){
                if(grid[j][i]=='0')
                    enemy[j][i] += e;
                else if(grid[j][i]=='E')
                    e++;
                else if(grid[j][i]=='W')
                    e=0;
            }
        }
        int maxe = 0;
        for(int i=0; i<n; i++){
            int e = 0;
            for(int j=m-1; j>=0; j--){
                if(grid[j][i]=='0'){
                    enemy[j][i] += e;
                    maxe = max(maxe, enemy[j][i]);
                }
                else if(grid[j][i]=='E')
                    e++;
                else if(grid[j][i]=='W')
                    e=0;
            }
        }
        
        return maxe;
        
    }

}
