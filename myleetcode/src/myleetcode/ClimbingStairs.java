package myleetcode;

public class ClimbingStairs {
	public int climbStairs(int n){
		if(n<2)
			return 1;
		int leftBranches = climbStairs(n-1);
		int rightBranches = climbStairs(n-2);
		return leftBranches + rightBranches;
	}
	
	public int method2(int n){
		int a=0;
		int b=1;
		for(int i=0; i<n; i++){
			int c = a+b;
			a = b;
			b=c;
		}
		return b;
	}
}
