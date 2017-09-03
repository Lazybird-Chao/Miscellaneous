package mylintcode;

import java.util.HashMap;
import java.util.Map;

public class PermutationIndex2 {
	public long permutationIndexII(int[] A) {
		if(A==null || A.length==0)
			return 0;
		
		Map<Integer, Integer> numberCount = new HashMap<Integer, Integer>();
		for(int i=0; i<A.length; i++) {
			if(numberCount.containsKey(A[i]))
				numberCount.put(A[i], numberCount.get(A[i])+1);
			else
				numberCount.put(A[i], 1);
		}
		long index = 0;
		for(int i=0; i<A.length; i++) {
			int k = A[i];
			for(int n: numberCount.keySet()) {
				int c = numberCount.get(n);
				if(n<k && c>0) {
					numberCount.put(n, c-1);
					index += countPermute(numberCount);
					numberCount.put(n, c);
				}
			}
			numberCount.put(k, numberCount.get(k)-1);
		}
		return index+1;
		
	}
	
	long countPermute(Map<Integer, Integer> numberCount) {
		int sum = 0;
		long dupf = 1;
		for(int n: numberCount.keySet()) {
			int c = numberCount.get(n);
			if(c>0) {
				sum += c;
				dupf *= f(c);
			}
		}
		return f(sum)/dupf;
	}
	
	
	long f(int x) {
		if(x<2)
			return 1;
		long ans = 1;
		for(int i=2; i<=x; i++)
			ans *= i;
		return ans;
	}

}
