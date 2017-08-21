package mylintcode;

public class JumpGame2 {
	public int jump(int[] A) {
		if(A==null || A.length==0)
			return 0;
		int[] minJump = new int[A.length];
		minJump[0] = 0;
		for(int i=1; i<A.length; i++)
			minJump[i] = Integer.MAX_VALUE;
		for(int i=0; i<A.length; i++) {
			for(int j=1; j<=A[i]; j++) {
				if(i+j<A.length)
					minJump[i+j] = Math.min(minJump[i+j], minJump[i]+1);
			}
		}
		if(minJump[A.length-1]==Integer.MAX_VALUE)
			return -1;
		return minJump[A.length-1];
	}

}
