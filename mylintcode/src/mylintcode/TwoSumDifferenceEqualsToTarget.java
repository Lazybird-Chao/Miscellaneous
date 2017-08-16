package mylintcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumDifferenceEqualsToTarget {
	public int[] twoSum7(int[] nums, int target) {
		if(nums==null || nums.length==0)
			return new int[2];
		int[] res = new int[2];
		Map<Integer, Integer> records = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			if(records.containsKey(nums[i])) {
				res[0] = records.get(nums[i])+1;
				res[1] = i+1;
			}
			else {
				if(!records.containsKey(nums[i]-target))
					records.put(nums[i]-target, i);
				if(!records.containsKey(nums[i]+target))
					records.put(nums[i]+target, i);
			}
		}
		return res;
	}

}
