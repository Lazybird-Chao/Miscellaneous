package mylintcode;

public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] p = new p[m][n];
		for(int i=0; i<m; i++)
			if(obstacleGrid[i][0]==1) {
				while(i<m) {
					p[i][0]=0;
					i++;
				}
			}
			else
				p[i][0] = 1;
		for(int i=0; i<n; i++)
			if(obstacleGrid[0][i]==1) {
				while(i<n) {
					p[0][i] = 0;
					i++;
				}
			}
			else
				p[0][i] = 1;
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				if(obstacleGrid[i][j]==1)
					p[i][j]=0;
				else
					p[i][j] = p[i-1][j]+p[i][j-1];
		return p[m-1][n-1];
		
	}
}
