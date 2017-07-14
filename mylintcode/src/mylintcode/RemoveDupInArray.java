package mylintcode;

import java.util.Arrays;

public class RemoveDupInArray {
	public int deduplication(int[] nums){
		if(nums == null || nums.length ==0)
			return 0;
		
		Arrays.sort(nums);
		int i, j;
		i=j=1;
		while(j<nums.length){
			if(nums[j]!=nums[j-1]){
				nums[i]=nums[j];
				i++;
				j++;
			}
			else
				j++;
		}
		return i;
	}

}
