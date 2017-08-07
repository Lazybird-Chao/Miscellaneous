package mylintcode;

public class KnightShortestPath2 {
	
	public class Point {
		      public int x, y;
		      public Point() { x = 0; y = 0; }
		      public Point(int a, int b) { x = a; y = b; }
		  }
	
	public int shortestPath2(boolean[][] grid) {
		if(grid==null)
			return -1;
		int h = grid.length;
		int w = grid[0].length;
		if(h==0 || w==0)
			return -1;
		
		int[][] pathGrid = new int[h][w];
		for(int i=0; i<h; i++)
			for(int j=0; j<w; j++)
				pathGrid[i][j]=Integer.MAX_VALUE;
		
		pathGrid[0][0] = 0;
		for(int j=0; j<w; j++) {
			for(int i=0; i<h; i++) {
				if(pathGrid[i][j]!=Integer.MAX_VALUE) {
					expand(grid, pathGrid, i, j);
				}
				if(pathGrid[h-1][w-1]!=Integer.MAX_VALUE)
					return pathGrid[h-1][w-1];
			}
		}
		if(pathGrid[h-1][w-1]==Integer.MAX_VALUE)
			return -1;
		else
			 return pathGrid[h-1][w-1];
	}
	
	void expand(boolean[][]grid, int[][] pathGrid, int i, int j) {
		int h= grid.length;
		int w = grid[0].length;
		int[] x = {1,-1,2,-2};
		int[] y = {2,2,1,1};
		for(int k=0; k<4; k++) {
			int newi = i+x[k];
			int newj = j+y[k];
			if(newi>=0 && newi<h && newj>=0 && newj<w) {
				if(grid[newi][newj] == false)
					pathGrid[newi][newj]  = Math.min(pathGrid[newi][newj], pathGrid[i][j]+1);
			}
		}
		
	}
}
