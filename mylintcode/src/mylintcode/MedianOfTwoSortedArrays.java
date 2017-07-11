package mylintcode;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] A, int[] B) {
		if(A==null || B==null)
			return 0;
		int kth;
		boolean odd = (A.length + B.length)%2==1;
		kth = odd ? (A.length + B.length)/2 +1 : (A.length + B.length)/2;
		if(kth==0)
		    return 0;
		return helper(A, 0, B, 0, kth, odd);
	}
	
	public double helper(int[] A, int startA, int[] B, int startB, int kth, boolean odd){
		if(kth==1){
			if(odd){
			    if(startB > B.length-1)
			        return A[startA];
			    else if(startA > A.length-1)
			        return B[startB];
			    else
				    return Math.min(A[startA], B[startB]);
			}
			else{
				if(startB>B.length-1)
			        return (double)(A[startA]+A[startA+1])/2;
			    else if(startA > A.length-1)
			        return (double)(B[startB]+B[startB+1])/2;
			    else{
			        int t1, t2;
			        if(A[startA] <= B[startB]){
			            t1 = A[startA];
			            if(startA+1 < A.length)
			                t2 = Math.min(A[startA+1], B[startB]);
			            else
			                t2 = B[startB];
			        }
			        else{
			            t1 = B[startB];
			            if(startB+1<B.length)
			                t2 = Math.min(A[startA], B[startB+1]);
			            else
			                t2 = A[startA];
			        }
				    return (double)(t1+t2)/2;
			    }
			}
		}
		int check = kth/2;
		if(startA + check-1 > A.length-1){
			startB += check;
		}
		else if(startB + check-1 > B.length-1){
			startA += check;
		}
		else{
			if(A[startA+check-1]<=B[startB+check-1])
				startA += check;
			else
				startB += check;
		}
		return helper(A, startA, B, startB, kth-check, odd);
	}
}
