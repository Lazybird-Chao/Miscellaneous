package mylintcode;

public class SearchInRotatedSortedArray2 {
	public boolean search(int[] A, int target) {
		if(A==null || A.length==0)
			return false;
		int left = 0;
		int right = A.length-1;
		while(left<right && A[right]==A[left])
			--right;
		while(left+1 < right){
			int mid = left+(right-left)/2;
			if(A[mid]==target)
				return true;
			else{
				if(A[mid]>=A[left]){
					if(A[mid]>target && target >=A[left])
						right = mid;
					else
						left = mid;
				}
				else{
					if(A[mid]<target && target <=A[right])
						left = mid;
					else
						right = mid;
				}
			}
		}
		if(A[left]==target)
			return true;
		else if(A[right]==target)
			return true;
		else
			return false;
	}

}
