package mylintcode;

import java.util.Arrays;

public class TwoSumGreaterThanTarget {
	public int twoSum2(int[] nums, int target) {
		if(nums==null || nums.length==0)
			return 0;
		Arrays.sort(nums);
		int i,j;
		i=0;
		j=nums.length-1;
		int count = 0;
		while(i<j) {
			if(nums[i]+nums[j]<=target) {
				++i;
			}
			else {
				count += j-i;
				--j;
			}
		}
		return count;
	}

}
