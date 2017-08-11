package mylintcode;

public class KClosestNumbersInSortedArray {
	public int[] kClosestNumbers(int[] A, int target, int k) {
		if(A==null || A.length==0 || k>A.length)
			return new int[0];
		int[] res = new int[k];
		if(target<=A[0]) {
			for(int i=0; i<k; i++)
				res[i] = A[i];
			return res;
		}
		if(target>=A[A.length-1]) {
			for(int i=0; i<k; i++)
				res[i] = A[A.length-1-i];
			return res;
		}
		
		int left = 0;
		int right = A.length-1;
		while(left+1 < right) {
			int mid = left+(right-left)/2;
			if(A[mid]>=target)
				right = mid;
			else
				left = mid;
		}
		if(A[left]>=target) {
			left--;
			right--;
		}
		int i=0;
		while(i<k && left>=0 && right<A.length) {
			if(target-A[left]<=A[right]-target) {
				res[i] = A[left];
				left--;
			}
			else {
				res[i] = A[right];
				right++;
			}
			i++;
		}
		if(i<k) {
			while(i<k && left>=0) {
				res[i] = A[left];
				left--;
				i++;
			}
			while(i<k && right<A.length) {
				res[i] = A[right];
				right++;
				i++;
			}

		}
		return res;
		
		
	}

}
