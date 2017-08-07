package mylintcode;

public class PerfectSquares {
	public int numSquares(int n) {
		int[] count = new int[n+1];
		for(int i=0; i<n+1; i++)
			count[i] = Integer.MAX_VALUE;
		count[1] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=1; j*j<=i; j++) {
				if(j*j==i)
					count[i] = 1; 
				else
					count[i] = Math.min(count[i], count[i-j*j]);
			}
		}
		return count[n];
	}

}
