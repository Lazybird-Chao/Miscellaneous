package mylintcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray2 {
	public int maxTwoSubArrays(List<Integer> nums) {
		if(nums==null || nums.size()==0)
			return 0;
		
		List<Integer> reverse = new ArrayList<Integer>();
		for(int j=nums.size(); j>=0; j--)
			reverse.add(nums.get(j));
		
		int[] maxsub = maxSub(nums);
		int[] rmaxsub = maxSub(reverse);
		int max = Integer.MIN_VALUE;
		for(int i=0; i<nums.size()-1; i++) {
			max = Math.max(maxsub[i] + rmaxsub[nums.size()-1-(i+1)], max);
		}
		return max;
		
		
	}
	
	int[] maxSub(List<Integer> nums) {
		int max =0;
		int minPre =0;
		int[] maxsub = new int[nums.size()];
		
		int sum = 0;
		max = nums.get(0);
		for(int i=0; i<nums.size(); i++) {
			sum += nums.get(i);
			max = Math.max(max, sum-minPre);
			minPre = Math.min(minPre, sum);
		}
		return maxsub;
	}

}
