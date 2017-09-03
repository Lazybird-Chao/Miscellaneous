package mylintcode;

import java.util.HashSet;
import java.util.Set;

public class PermutationIndex {
	 public long permutationIndex(int[] A) {
		 if(A==null || A.length==0)
			 return 0;
		 Set<Integer> s = new HashSet<Integer>();
		 for(int i=0; i<A.length; i++)
			 s.add(A[i]);
		 int index=0;
		 for(int i=0; i<A.length; i++) {
			 int k = A[i];
			 s.remove(k);
			 int count =0;
			 for(int number: s) {
				 if(number < k)
					 count++;
			 }
			 if(count>0)
				 index += count*f(A.length-1-i);
		 }
		 return index+1;
	 }
	 
	 long f(int x) {
		 long r = 1;
		 for(int i=1; i<=x; i++)
			 r *= i;
		 return r;
	 }

}
