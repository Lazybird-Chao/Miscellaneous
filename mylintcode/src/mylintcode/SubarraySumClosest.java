package mylintcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumClosest {
	public int[] subarraySumClosest(int[] nums) {
		if(nums==null || nums.length==0)
			return new int[0];
		Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
		int[] preSumArray = new int[nums.length+1];
		preSum.put(0, -1);
		preSumArray[0] = 0;
		int sum = 0;
		for(int i=0; i<nums.length; i++){
			sum += nums[i];
			if(preSum.containsKey(sum)){
				int[] res = new int[2];
				res[0] = preSum.get(sum)+1;
				res[1] = i;
				return res;
			}
			else{
				preSum.put(sum, i);
				preSumArray[i+1] = sum;
			}
			
		}
		Arrays.sort(preSumArray);
		int min = preSumArray[1] - preSumArray[0];
		int minP = 0;
		for(int i=1; i<preSumArray.length; i++){
			if(min > preSumArray[i]-preSumArray[i-1]){
				min = preSumArray[i]-preSumArray[i-1];
				minP = i-1;
			}
		}
		int[] res = new int[2];
		if(preSum.get(preSumArray[minP])< preSum.get(preSumArray[minP+1])){
			res[0] = preSum.get(preSumArray[minP])+1;
			res[1] = preSum.get(preSumArray[minP+1]);
		}
		else{
			res[1] = preSum.get(preSumArray[minP]);
			res[0] = preSum.get(preSumArray[minP+1])+1;
		}
		return res;
		
	}

}
