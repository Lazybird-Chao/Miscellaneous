package myleetcode;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQuery {
	public class NumArray{
		int[] numArray;
		Map<Integer, Integer> cache;
		
		public NumArray(int[] nums){
			numArray = nums;
			cache = new HashMap<Integer, Integer>();
			
		}
		
		public int sumRange(int i, int j){
			int vi=0;
			int vj=0;
			if(cache.containsKey(i))
				vi = cache.get(i);
			else{
				for(int k=0; k<=i; k++)
					vi+=numArray[k];
				cache.put(i, vi);
			}
			if(cache.containsKey(j))
				vj = cache.get(j);
			else{
				for(int k=0; k<=j; k++)
					vj+=numArray[k];
				cache.put(j, vj);
			}
			return vj-vi + numArray[i];
		}
	}
	
	public class NumArray2{
		int[] numArray;	
		public NumArray2(int[] nums){
			numArray = nums;
			for(int i=1; i<numArray.length; i++)
				numArray[i] += numArray[i-1];	
		}
		
		public int sumRange(int i, int j){
			return i==0? numArray[j] : numArray[j]-numArray[i-1]; //
		}
	}
}
