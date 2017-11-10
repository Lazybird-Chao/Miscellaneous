package google;

public class IslandPerimeter {
	 public int islandPerimeter(int[][] grid) {
	        if(grid == null || grid.length == 0 || grid[0].length ==0)
	            return 0;
	        int res = 0;
	        for(int i = 0; i < grid.length; i++){
	            for(int j = 0; j < grid[0].length; j++){
	                if(grid[i][j] == 1){
	                    res += 4;
	                    if(i-1>=0 && grid[i-1][j]==1)
	                        res--;
	                    if(i+1 < grid.length && grid[i+1][j] == 1)
	                        res--;
	                    if(j-1>=0 && grid[i][j-1]==1)
	                        res--;
	                    if(j+1<grid[0].length && grid[i][j+1] == 1)
	                        res--;
	                }
	            }
	        }
	        return res;
	    }

}
