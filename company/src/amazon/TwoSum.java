package amazon;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return new int[0];
		Map<Integer, Integer> compliment = new HashMap<Integer, Integer>();
		int[] res = null;
		for(int i=0; i<nums.length; i++) {
			if(compliment.containsKey(nums[i])) {
				res = new int[2];
				res[0] = i;
				res[1] = compliment.get(nums[i]);
				break;
			} else {
				compliment.put(target - nums[i], i);
			}
		}
		if(res == null)
			return new int[0];
		else
			return res;
	}

}
