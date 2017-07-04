package mylintcode;

public class ClosestNumInSortedArray {
	public int closestNumber(int[] A, int target) {
		if(A==null || A.length==0)
			return -1;
		
		int start,end;
		start = 0;
		end = A.length-1;
		while(start+1 < end){
			int mid = start + (end-start)/2;
			if(A[mid] == target)
				return mid;
			else if(A[mid]>target)
				end = mid;
			else
				start = mid;
		}
		if(Math.abs(A[start]-target) < Math.abs(A[end]-target))
				return start;
		else
			return end;
	}

}
