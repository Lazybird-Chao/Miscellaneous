package mylintcode;

import java.util.Arrays;

public class TwoSumLessOrEaque {
	public int twoSum5(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int i, j;
		i = 0; 
		j = nums.length-1;
		int count = 0;
		while(i < j){
			int sum = nums[i] + nums[j];
			if(sum < target){
				count += j-i;
				i++;
			}
			else{
				j--;
			}
		}
		return count;
	}

}
