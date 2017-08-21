package mylintcode;

public class ClimbingStairs2 {
	public int climbStairs2(int n) {
		if(n==0)
			return 0;
		int[] f = new int[n+1];
		f[1] = 1;
		for(int i=2; i<n; i++) {
			if(i-3>=1)
				f[i]+=f[i-3];
			if(i-2>=1)
				f[i]+=f[i-2];
			if(i-1>=1)
				f[i]+=f[i-1];
		}
		return f[n];
	}

}
