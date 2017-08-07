package mylintcode;

public class JumpGame {
	public boolean canJump(int[] A) {
		if(A==null || A.length==0)
			return false;
		boolean[] canjump = new boolean[A.length];
		canjump[0] = true;
		for(int i=1; i<A.length; i++) {
			for(int j=0; j<i; j++) {
				if(canjump[j]==true && A[j]+j>=i) {
					canjump[i] = true;
					break;
				}
			}
		}
		return canjump[A.length-1];
	}
	
	public boolean method2(int[] A) {
		if(A==null || A.length==0)
			return false;
		boolean[] canjump = new boolean[A.length];
		canjump[0] = true;
		for(int i=0; i<A.length; i++) {
			if(canjump[i]==true) {
				for(int j=1; j<=A[i]; j++) {
					canjump[i+j] = true;
				}
			}
			if(canjump[A.length-1]==true)
				break;
		}
		return canjump[A.length-1];
	}
	
	public boolean method3(int[] A) {
		if(A==null || A.length==0)
			return false;
		int maxJump = A[0];
		for(int i=1; i<A.length; i++) {
			if(maxJump>=i)
				maxJump = Math.max(maxJump, i+A[i]);
			if(maxJump>=A.length-1)
				break;
		}
		return maxJump>=A.length-1;
	}

}
