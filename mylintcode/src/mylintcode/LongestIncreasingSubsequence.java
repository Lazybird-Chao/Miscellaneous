package mylintcode;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
	public int longestIncreasingSubsequence(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		int[] preIndex = new int[nums.length];
		int[] subLength = new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			preIndex[i] = i;
			subLength[i] = 1;
		}
		int maxSub = 1;
		int maxSubIndex = 0;
		for(int i=1; i<nums.length; i++) {
			for(int j=i-1; j>=0; j--) {
				if(nums[i]>=nums[j] && subLength[i]<subLength[j]+1) {
					subLength[i] = subLength[j]+1;
					preIndex[i] = j;
				}
			}
			if(maxSub<subLength[i]) {
				maxSub = subLength[i];
				maxSubIndex = i;
			}
		}
		ArrayList<Integer> subseq = new ArrayList<Integer>();
		int pre = maxSubIndex;
		while(preIndex[pre] != pre) {
			subseq.add(nums[pre]);
			pre = preIndex[pre];
		}
		subseq.add(nums[pre]);
		
		return maxSub;
		
		
	}

}
