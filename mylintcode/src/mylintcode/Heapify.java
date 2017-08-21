package mylintcode;

public class Heapify {
	public void heapify(int[] A) {
		if(A==null)
			return;
		int n = A.length;
		int k = (n-1)/2;
		for(int i=k; i>=0; i--) {
			heapdown(A, i);
		}
		return;
	}
	
	void heapdown(int[] A, int start) {
		while(2*start+1<A.length) {
			if(2*start+2<A.length && A[2*start+1]>A[2*start+2]) {
				if(A[start]>A[2*start+2]) {
					int tmp = A[start];
					A[start] = A[2*start+2];
					A[2*start+2] = tmp;
					start = 2*start+2;
				}
				else
					break;
			}
			else if(A[start]>A[2*start+1]) {
				int tmp = A[start];
				A[start] = A[2*start+1];
				A[2*start+1] = tmp;
				start = 2*start+1;
			}
			else
				break;
		}
		return;
	}

}
