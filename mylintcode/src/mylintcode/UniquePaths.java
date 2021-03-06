package mylintcode;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] p = new int[m][n];
		for(int i=0; i<m; i++)
			p[i][0] = 1;
		for(int i=0; i<n; i++)
			p[0][i] = 1;
		for(int i=1; i<m; i++)
			for(int j=1; j<n; j++)
				p[i][j] = p[i-1][j] + p[i][j+1];
		return p[m-1][n-1];
	}
	
}
