package mylintcode;

public class MergeSortedArray {
	 public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		 if(A==null || B==null)
			 return;
		 int i=m-1;
		 int j=n-1;
		 int k = m+n-1;
		 while(i>=0 && j>=0) {
			 if(A[i]>B[j]) {
				 A[k]=A[i];
				 i--;
			 }
			 else {
				 A[k]=B[j];
				 j--;
			 }
			 k--;
		 }
		 while(i>=0) {
			 A[k] = A[i];
			 --i;
			 --k;
		 }
		 while(j>=0) {
			 A[k]=B[j];
			 --j;
			 --k;
		 }
		 return;
	 }

}
