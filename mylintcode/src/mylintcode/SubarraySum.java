package mylintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
	public ArrayList<Integer> subarraySum(int[] nums) {
		if(nums==null || nums.length==0)
			return new ArrayList<Integer>();
		
		Map<Integer, Integer> subSum = new HashMap<Integer, Integer>();
		int i = 0;
		int sum = 0;
		subSum.put(0,0);
		while(i<nums.length){
			sum += nums[i];
			if(subSum.containsKey(sum)){
				ArrayList<Integer> res = new ArrayList<Integer>();
				res.add(subSum.get(sum));
				res.add(i);
			}
			else
				subSum.put(sum, i);
			i++;
		}
		return new ArrayList<Integer>();
	}

}
