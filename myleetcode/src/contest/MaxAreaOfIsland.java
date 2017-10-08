package contest;

public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length ==0)
            return 0;
        int maxarea = 0;
        for(int i =0; i < grid.length; i++){
            for(int j = 0; j<grid[0].length; j++)
                if(grid[i][j] == 1)
                    maxarea = Math.max(maxarea, expand(grid, i, j));
        }
        return maxarea;
        
    }
    int expand(int[][] grid, int i, int j){
        if(i < 0 || i>=grid.length || j < 0 || j >= grid[0].length)
            return 0;
        if(grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int area = 1;
        area += expand(grid, i+1, j);
        area += expand(grid, i-1, j);
        area += expand(grid, i, j+1);
        area += expand(grid, i, j-1);
        return area;
    }

}
