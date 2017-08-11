package mylintcode;

public class TotalOccurrenceofTarget {
	public int totalOccurrence(int[] A, int target) {
		if(A==null || A.length==0)
			return 0;
		if(target>A[A.length-1] || target<A[0])
			return 0;
		int left = 0;
		int right = A.length-1;
		while(left+1<right) {
			int mid = left+(right-left)/2;
			if(A[mid] >= target)
				right = mid;
			else 
				left = mid;
		}
		int start;
		if(A[left]==target)
			start = left;
		else if(A[right]==target)
			start = right;
		else 
			return 0;
		int count = 1;
		for(int i=start+1; i<A.length; i++) {
			if(A[i]==A[start])
				count++;
			else
				break;
		}
		return count;
	}

}
