package mylintcode;

public class FindPeakElement {
	public int findPeak(int[] A) {
		if(A==null || A.length==0)
			return -1;
		int start = 0;
		int end = A.length-1;
		while(start+1 < end){
			int mid = start + (end-start)/2;
			if(A[mid]>A[mid-1] && A[mid]>A[mid+1])
				return mid;
			else if(A[mid]>A[mid-1] && A[mid+1]>A[mid])
				start = mid;
			else if(A[mid]<A[mid-1] && A[mid]>A[mid+1])
				end = mid;
			else if(A[mid]<A[mid-1] && A[mid]<A[mid+1])
				end = mid;
		}
		return -1;
	}

}
