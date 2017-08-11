package mylintcode;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		if(A==null || A.length==0)
			return new int[0];
		if(target>A[A.length-1] || target<A[0]) {
			int[] res = {-1,-1};
			return res;
		}
		int left = 0;
		int right = A.length-1;
		while(left+1 < right) {
			int mid = left + (right-left)/2;
			if(A[mid]>=target)
				right = mid;
			else
				left = mid;
		}
		int start=-1;
		int end = -1;
		int[] res = {-1,-1};
		if(A[left]==target)
			start = left;
		else if(A[right]==target)
			start = right;
		else 
			return res;
		for(end = start+1; end<A.length; end++)
			if(A[end] != A[start])
				break;
		res[0]=start;
		res[1]=end-1;
		return res;
	}

}
