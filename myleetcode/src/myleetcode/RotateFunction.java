package myleetcode;

public class RotateFunction {
	public int maxRotateFunction(int[] A){
		int sumA=0;
		for(int i=0; i<A.length; i++)
			sumA += A[i];
		int f0 = 0;
		for(int i=0; i<A.length;i++)
			f0+=i*A[i];
		
		int max=f0;
		int fi=f0;
		for(int i=A.length-1; i>=1; i--){
			fi = fi + (sumA - A[i]) - (A.length-1)*A[i];
			if(fi >max)
				max = fi;
		}
		return max;
	}
}
