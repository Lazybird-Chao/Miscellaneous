package mylintcode;

public class MergeTwoSortedArrays {
	public int[] mergeSortedArray(int[] A, int[] B) {
		if(A==null && B==null)
			return new int[0];
		else if(A==null)
			return B;
		else if(B==null)
			return A;
		
		int[] res = new int[A.length+B.length];
		int i,j,k;
		i=j=k=0;
		while(i<A.length && j<B.length) {
			if(A[i]<B[j]) {
				res[k]=A[i];
				++i;
			}
			else {
				res[k]=B[j];
				++j;
			}
			++k;
		}
		while(i<A.length) {
			res[k]=A[i];
			++i;
			++k;
		}
		while(j<B.length) {
			res[k]=B[j];
			++j;
			++k;
		}
		return res;
		
	}

}
