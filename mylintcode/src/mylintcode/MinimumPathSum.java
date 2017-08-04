package mylintcode;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if(grid==null)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		if(m==0 || n==0)
			return 0;
		int[][] minSumGrid = new int[m][n];
		minSumGrid[0][0] = grid[0][0];
		for(int i=1; i<n; i++)
			minSumGrid[0][i] = grid[0][i]+minSumGrid[0][i-1];
		for(int i=0; i<m; i++)
			minSumGrid[i][0] = minSumGrid[i-1][0] + grid[i][0];
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				minSumGrid[i][j] = Math.min(minSumGrid[i-1][j], minSumGrid[i][j-1]) + grid[i][j];
		return minSumGrid[m-1][n-1];
	}
}
