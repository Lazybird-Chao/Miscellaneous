package myleetcode;

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums){
		if(nums == null || nums.length==0)
			return 0;
		Arrays.sort(nums);
		
		int length1=1, length2=0;
		int maxlen = 0;
		int i=0;
		while(i<nums.length-1 && nums[i]==nums[i+1]){
			length1++;
			i++;
		}
		maxlen = 0;
		i++;
		
		while(i<nums.length){
			length2 = 1;
			while(i<nums.length-1 && nums[i]==nums[i+1]){
				length2++;
				i++;
			}
			if(Math.abs(nums[i]-nums[i-length2])==1)
				maxlen = Math.max(length1+length2, maxlen);
			length1 = length2;
			i++;
		}
		
		return maxlen;
		
		
	}

}
