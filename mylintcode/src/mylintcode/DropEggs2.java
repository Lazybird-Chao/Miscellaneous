package mylintcode;

public class DropEggs2 {
	public int dropEggs2(int m, int n) {
		int[][] f = new int[m+1][n+1];
		for(int i=0; i<=n; i++) {
			f[0][i] = 0;
			f[1][i] = i;
		}
		for(int i=0; i<=m; i++) {
			f[i][0] = 0;
			f[i][1] = 1;
		}
		for(int i=2; i<=m; i++) {
			for(int j=2; j<=n; j++) {
				f[i][j] = Integer.MAX_VALUE;
				for(int k=1; k<=j; k++)
					f[i][j] = Math.min(f[i][j],  Math.max(f[i-1][k-1], f[i][j-k]) + 1);
			}
		}
		return f[m][n];
	}

}
