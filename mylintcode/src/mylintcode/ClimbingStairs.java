package mylintcode;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if(n==0)
			return 0;
		int[] climbN = new int[n+1];
		climbN[0]=0;
		climbN[1]=1;
		for(int i=0; i<=n; i++)
			climbN[i] = climbN[i-1] + climbN[i];
		return climbN[n];
	}
}
