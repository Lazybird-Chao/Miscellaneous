package myleetcode;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid){
		int ret = 0;
		for(int i=0; i< grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] == 1){
					if(i==0 || grid[i-1][j] ==0)
						ret++;
					if(i==grid.length-1 || grid[i+1][j] == 0)
						ret++;
					if(j==0 || grid[i][j-1]==0)
						ret++;
					if(j==grid[0].length-1 || grid[i][j+1]==0)
						ret++;
				}
			}
		}
		return ret;
	}
	
	public int method2(int[][] grid){
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
	}
	
	public int method3(int[][] grid) {
        for (int i = 0;i<grid.length;i++) {
            for (int j = 0;j<grid[i].length;j++) {
                if (grid[i][j] == 1) return dfs(grid, i, j);
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i<0 || i == grid.length || j<0 || j==grid[0].length) return 1;
        if (grid[i][j] == 0) return 1;
        if (grid[i][j] == -1) return 0;
        grid[i][j] = -1;
        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}
