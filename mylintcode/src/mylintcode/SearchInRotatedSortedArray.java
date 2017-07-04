package mylintcode;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		if(A==null || A.length==0)
			return -1;
		int start = 0;
		int end = A.length-1;
		while(start + 1 < end){
			int mid = start + (end-start)/2;
			if(A[mid]== target)
				return mid;
			else if(A[mid]<target){
			    if(target<= A[end] || A[mid]>A[end])
			        start = mid;
			    else
			        end = mid;
			}
			else if(A[mid]>target){
			    if(target>=A[start] || A[mid] < A[start])
			        end = mid;
			    else
			        start = mid;
			}		
		}
		if(A[start]==target)
			return start;
		else if(A[end]==target)
			return end;
		else
			return -1;
	}

}
