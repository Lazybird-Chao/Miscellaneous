package myleetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
		int res=0;
		Map<Integer, Integer>sumMap = new HashMap<Integer, Integer>();
		for(int i=0; i<A.length; i++){
			for(int j=0; j<B.length; j++){
				sumMap.put(A[i]+B[j], sumMap.getOrDefault(A[i]+B[j], 0)+1);
			}
		}
		
		for(int i=0; i<C.length; i++){
			for(int j=0; j<D.length; j++){
				if(sumMap.containsKey(-(C[i]+D[j])))
					res += sumMap.get(-(C[i]+D[j]));
			}
		}
		return res;
	}
}
