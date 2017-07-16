package mylintcode;

import java.util.Arrays;

public class TwoSumUniquePairs {
	public int twoSum6(int[] nums, int target) {
		if( nums == null || nums.length ==0)
			return 0;
		Arrays.sort(nums);
		int i,j;
		i=0;
		j=nums.length-1;
		int count = 0;
		while(i < j){
			int sum = nums[i]+nums[j];
			if(sum==target){
				count++;
				i++;
				j--;
				while(i<j && nums[i]==nums[i-1])
					i++;
				while(i<j && nums[j]==nums[j+1])
					j--;
			}
			else if(sum > target){
				j--;
			}
			else{
				i++;
			}
		}
		return count;
	}

}
